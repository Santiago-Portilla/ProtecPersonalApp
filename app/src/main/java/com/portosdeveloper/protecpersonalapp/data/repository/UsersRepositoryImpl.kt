package com.portosdeveloper.protecpersonalapp.data.repository

import android.net.Uri
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.storage.StorageReference
import com.portosdeveloper.protecpersonalapp.core.Constants.USERSWORKSHOP
import com.portosdeveloper.protecpersonalapp.domain.module.Response
import com.portosdeveloper.protecpersonalapp.domain.module.User
import com.portosdeveloper.protecpersonalapp.domain.repository.UsersRepository
import com.portosdeveloper.protecpersonalapp.presentation.utils.ActualDate
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import java.io.File
import javax.inject.Inject
import javax.inject.Named

class UsersRepositoryImpl @Inject constructor(
    @Named(USERSWORKSHOP) private val userRef : CollectionReference,
    @Named(USERSWORKSHOP) private val storageUsersRef: StorageReference
) : UsersRepository {


    override suspend fun create(user: User): Response<Boolean> {

        return try {
            userRef.document(user.id).set(user).await()
            Response.Success(true)
        }
        catch (e : Exception){
            e.printStackTrace()
            Response.Failure(e)
        }

    }

    override suspend fun update(user: User): Response<Boolean> {
        return try{
            val map: MutableMap<String, Any> = HashMap()
            map["image"] = user.image
            userRef.document(user.id).update(map).await()
            Response.Success(true)

        }catch (e: Exception){
            e.printStackTrace()
            Response.Failure(e)
        }
    }


    override suspend fun saveImage(file: File): Response<String> {
        return try {
            val fromFile = Uri.fromFile(file)
            val ref = storageUsersRef.child(file.name)
            val uploadTask = ref.putFile(fromFile).await()
            val url = ref.downloadUrl.await()
            return Response.Success(url.toString())
        }catch (e: Exception){
            e.printStackTrace()
            Response.Failure(e)
        }
    }

    override fun getUserById(id: String): Flow<User> = callbackFlow{
        val snapshotListener = userRef.document(id).addSnapshotListener{
                snapshot, e ->
            val user = snapshot?.toObject(User::class.java) ?: User()
            trySend(user)
        }
        awaitClose{
            snapshotListener.remove()
        }
    }

    override fun getUser(id: String): Flow<Response<User>> = callbackFlow{
        val snapshotListener = userRef.document(id).addSnapshotListener{
                snapshot,e ->
            val userResponse = if(snapshot != null){
                val user = snapshot.toObject(User :: class.java)!!
                Response.Success(user)
            }else{
                Response.Failure(e!!)
            }
            trySend(userResponse)
        }
        awaitClose{
            snapshotListener.remove()
        }
    }

    override suspend fun updateSalaryWorkDay(user: User, newDate: String): Response<Boolean> {
        return try{
            val map: MutableMap<String, Any> = HashMap()
            map["workDay"] = "0"
            map[""] = newDate
            userRef.document(user.id).update(map).await()
            Response.Success(true)

        }catch (e: Exception){
            e.printStackTrace()
            Response.Failure(e)
        }
    }

}