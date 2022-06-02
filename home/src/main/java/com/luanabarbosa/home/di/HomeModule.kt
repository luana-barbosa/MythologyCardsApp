package com.luanabarbosa.home.di

import com.luanabarbosa.home.data.mapper.HomeMapper
import com.luanabarbosa.home.data.mapper.HomeMapperImpl
import com.luanabarbosa.home.data.repository.AppHomeRepository
import com.luanabarbosa.home.data.repository.HomeRepository
import com.luanabarbosa.home.data.service.HomeApi
import com.luanabarbosa.home.domain.GetHomeCards
import com.luanabarbosa.home.domain.GetHomeCardsUseCase
import com.luanabarbosa.home.ui.HomeCardViewModel
import com.luanabarbosa.network.retrofit.NetworkInicialization
import org.koin.dsl.module

val homeModule = module {
    single { NetworkInicialization().createService(HomeApi::class.java) }
    single <HomeRepository> { AppHomeRepository(get(), get()) }
    single<GetHomeCardsUseCase> { GetHomeCards(get()) }
    factory<HomeMapper> { HomeMapperImpl() }
    single { HomeCardViewModel(get()) }
}
