package com.alvarado.backpack.util

import com.alvarado.backpack.data.remote.model.PostResponse
import com.alvarado.backpack.data.remote.model.SubjectResponse
import com.alvarado.backpack.data.remote.model.UserResponse
import com.alvarado.backpack.domain.model.PostModel
import com.alvarado.backpack.domain.model.SubjectModel
import com.alvarado.backpack.domain.model.UserModel

fun convertToPostModel(post : PostResponse) : PostModel {
    return PostModel(
        id = post.id,
        title = post.title,
        url = post.url,
        category = post.category,
        subject = convertToSubjectModel(post.subject),
        publicationYear = post.publicationYear,
        publicationCycle = post.publicationCycle,
        author = convertToUserModel(post.author),
        hidden = post.hidden,
        topics = post.topics
    )
}

fun convertToSubjectModel(subject : SubjectResponse) : SubjectModel {
    return SubjectModel(
        id = subject.id,
        code = subject.code,
        name = subject.name,
        image = subject.image
    )
}

fun convertToUserModel(user : UserResponse) : UserModel {
    return UserModel(
        id = user.id,
        carnet = user.carnet,
        name = user.name,
        lastname = user.lastname,
        email = user.email,
        degree = user.degree,
        savedPosts = user.savedPosts ?: emptyList()
    )
}
