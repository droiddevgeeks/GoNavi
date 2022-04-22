package com.example.githubdata.di

import com.example.githubdata.closedmr.GithubRepository
import com.example.githubdata.network.ApiConstants
import com.example.githubdata.network.GithubApi
import com.example.githubdomain.IGithubRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiConstants.GITHUB_BASE_URL)
            .client(OkHttpClient.Builder().build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideGithubRepository(apiService: GithubApi): IGithubRepository {
        return GithubRepository(apiService)
    }

    @Provides
    fun provideService(retrofit: Retrofit): GithubApi {
        return retrofit.create(GithubApi::class.java)
    }
}