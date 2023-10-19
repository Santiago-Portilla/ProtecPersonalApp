package com.portosdeveloper.protecpersonalapp.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.portosdeveloper.protecpersonalapp.core.Constants.BUTTON
import com.portosdeveloper.protecpersonalapp.core.Constants.CLOTH
import com.portosdeveloper.protecpersonalapp.core.Constants.PACKING
import com.portosdeveloper.protecpersonalapp.core.Constants.PLOTTER
import com.portosdeveloper.protecpersonalapp.core.Constants.REFLECTIVE
import com.portosdeveloper.protecpersonalapp.core.Constants.ROLLWADDING
import com.portosdeveloper.protecpersonalapp.core.Constants.THREAD
import com.portosdeveloper.protecpersonalapp.core.Constants.TOTALCLOTH
import com.portosdeveloper.protecpersonalapp.core.Constants.USERSWORKSHOP
import com.portosdeveloper.protecpersonalapp.core.Constants.WADDING
import com.portosdeveloper.protecpersonalapp.core.Constants.YARN
import com.portosdeveloper.protecpersonalapp.data.repository.AuthRepositoryImpl
import com.portosdeveloper.protecpersonalapp.data.repository.UsersRepositoryImpl
import com.portosdeveloper.protecpersonalapp.domain.repository.AuthRepository
import com.portosdeveloper.protecpersonalapp.domain.repository.UsersRepository
import com.portosdeveloper.protecpersonalapp.domain.use_cases.auth.*
import com.portosdeveloper.protecpersonalapp.domain.use_cases.user.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named


@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun providesFireBaseFireStore(): FirebaseFirestore = Firebase.firestore

    @Provides
    fun provideFirebaseStorage(): FirebaseStorage = FirebaseStorage.getInstance()

    @Provides
    @Named(USERSWORKSHOP)
    fun providesUsersRef(db : FirebaseFirestore) : CollectionReference = db.collection(USERSWORKSHOP)

    @Provides
    @Named(USERSWORKSHOP)
    fun provideStorageUsersRef(storage : FirebaseStorage): StorageReference = storage.reference.child(USERSWORKSHOP)

    @Provides
    @Named(CLOTH)
    fun providesClothRef(db : FirebaseFirestore) : CollectionReference = db.collection(CLOTH)

    @Provides
    @Named(TOTALCLOTH)
    fun providesTotalClothRef(db : FirebaseFirestore) : CollectionReference = db.collection(TOTALCLOTH)

    @Provides
    @Named(PLOTTER)
    fun providesPlotterRef(db : FirebaseFirestore) : CollectionReference = db.collection(PLOTTER)

    @Provides
    @Named(WADDING)
    fun providesWaddingRef(db : FirebaseFirestore) : CollectionReference = db.collection(WADDING)

    @Provides
    @Named(ROLLWADDING)
    fun providesRollWaddingRef(db : FirebaseFirestore) : CollectionReference = db.collection(ROLLWADDING)

    @Provides
    @Named(THREAD)
    fun providesThreadRef(db : FirebaseFirestore) : CollectionReference = db.collection(THREAD)

    @Provides
    @Named(YARN)
    fun providesYarnRef(db : FirebaseFirestore) : CollectionReference = db.collection(YARN)

    @Provides
    @Named(REFLECTIVE)
    fun providesReflectiveRef(db : FirebaseFirestore) : CollectionReference = db.collection(REFLECTIVE)

    @Provides
    @Named(BUTTON)
    fun providesButtonRef(db : FirebaseFirestore) : CollectionReference = db.collection(BUTTON)

    @Provides
    @Named(PACKING)
    fun providesPackingRef(db : FirebaseFirestore) : CollectionReference = db.collection(PACKING)

    @Provides
    fun provideAuthRepository(Impl : AuthRepositoryImpl) : AuthRepository = Impl

    @Provides
    fun providesUsersRepository(Impl : UsersRepositoryImpl) : UsersRepository = Impl

    @Provides
    fun provideAuthUseCases(repository : AuthRepository) = AuthUseCases(
        login = Login(repository),
        getCurrentUser = GetCurrentUser(repository),
        signUp = SignUp(repository),
        logOut = LogOut(repository)
    )

    @Provides
    fun provideUserUseCases(repository : UsersRepository) = UserUseCases(
        create = Create(repository),
        getUserById = GetUserById(repository),
        update = Update(repository),
        saveImage = SaveImage(repository),
        getUser = GetUser(repository),
        updateSalaryWorkDay = UpdateSalaryWorkDay(repository)
    )



}