package com.example.justmanga.domain.koin

import com.example.justmanga.data.apiservice.manga.JMMangaApiService
import com.example.justmanga.data.apiservice.tag.JMTagApiService
import com.example.justmanga.data.datasource.manga.JMMangaDataSource
import com.example.justmanga.data.datasource.manga.JMMangaDataSourceImpl
import com.example.justmanga.data.datasource.tag.JMTagDataSource
import com.example.justmanga.data.datasource.tag.JMTagDataSourceImpl
import com.example.justmanga.data.mapper.manga.response.JMMangaResponseMapper
import com.example.justmanga.data.mapper.tag.response.JMTagResponseMapper
import com.example.justmanga.data.repository.manga.JMMangaRepositoryImpl
import com.example.justmanga.data.repository.tag.JMTagRepositoryImpl
import com.example.justmanga.domain.repository.manga.JMMangaRepository
import com.example.justmanga.domain.repository.tag.JMTagRepository
import com.example.justmanga.presentation.vm.JMDashboardHomePageVM
import com.example.justmanga.presentation.vm.JMDashboardSearchPageVM
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val modules = module {
    //api services
    single { provideOkHttpClient() }
    single { provideRetrofit(get())}
    single { get<Retrofit>().create(JMMangaApiService::class.java) }
//        single { get<Retrofit>().create(JMCoverApiService::class.java) }
//        single { get<Retrofit>().create(JMChapterApiService::class.java) }
        single { get<Retrofit>().create(JMTagApiService::class.java) }

    //data sources
    single<JMMangaDataSource> { JMMangaDataSourceImpl(get()) }
//        single<JMCoverDataSource> { JMCoverDataSourceImpl(get()) }
    single<JMTagDataSource> { JMTagDataSourceImpl(get()) }
//        single<JMChapterDataSource> { JMChapterDataSourceImpl(get()) }

    //mappers
    single { JMMangaResponseMapper() }
    single { JMTagResponseMapper() }

    // repositories
    single<JMMangaRepository> { JMMangaRepositoryImpl(get(), get()) }
    single<JMTagRepository> { JMTagRepositoryImpl(get(), get()) }
//        single<JMCoverRepository> { JMCoverRepositoryImpl(get(), get(), get()) }


    viewModel { JMDashboardHomePageVM(get()) }
    viewModel { JMDashboardSearchPageVM(get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl("https://api.mangadex.org/").client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient().newBuilder().build()
}