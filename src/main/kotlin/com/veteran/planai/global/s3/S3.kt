package com.veteran.planai.global.s3

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.model.PutObjectRequest
import com.veteran.planai.global.common.enums.FileType
import com.veteran.planai.global.common.repository.UserSecurity
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.multipart.MultipartFile
import java.util.*

@Configuration
@Service
class S3(
    private val s3Properties: S3Properties,
    private val userSecurity: UserSecurity,
) {
    @Bean
    fun amazonS3Client(): AmazonS3 {
        return AmazonS3ClientBuilder.standard()
            .withCredentials(
                AWSStaticCredentialsProvider(BasicAWSCredentials(s3Properties.accessKey, s3Properties.secretKey))
            )
            .withRegion(Regions.AP_NORTHEAST_2)
            .build()
    }

    fun uploadImage(
        @RequestPart file: MultipartFile?,
        fileType: FileType,
        title: String?
    ): String {
        val userId = userSecurity.getUser().id
        if (file == null) {
            throw RuntimeException("image is empty")
        }

        val fileName = createFileName( fileType,file.originalFilename ?: file.name)

        val objectMetadata = ObjectMetadata().apply {
            this.contentType = file.contentType
            this.contentLength = file.size
        }

        try {
            val putObjectRequest = PutObjectRequest(
                s3Properties.bucket,
                fileName,
                file.inputStream,
                objectMetadata
            ).withCannedAcl(CannedAccessControlList.PublicRead)  // 퍼블릭 읽기 권한 설정

            amazonS3Client().putObject(putObjectRequest)
        } catch (e: Exception) {
            throw RuntimeException("image upload failed", e)
        }
        val imageUrl = amazonS3Client().getUrl(s3Properties.bucket, fileName).toString()
        when(fileType) {
            FileType.LOGO -> {
//                profileImageRepository.save(ProfileImageEntity(userId = userId, imageUrl = imageUrl))
            }
            FileType.UI_UX -> {
//                afterImageRepository.save(AfterImageEntity(userId = userId, imageUrl = imageUrl))
            }
            else -> {
                throw RuntimeException("unknown file type $fileType")
            }
        }
        return imageUrl
    }

    private fun createFileName(fileType:FileType, originalName: String): String {
        return fileType.name+"/" + UUID.randomUUID() + "-" + originalName
    }

}