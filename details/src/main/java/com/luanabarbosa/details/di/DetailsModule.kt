package com.luanabarbosa.details.di

import com.luanabarbosa.details.data.repository.AppDetailsRepository
import com.luanabarbosa.details.data.repository.DetailsRepository
import com.luanabarbosa.details.data.service.DetailsApi
import com.luanabarbosa.details.domain.mapper.DetailsMapper
import com.luanabarbosa.details.domain.mapper.DetailsMapperImpl
import com.luanabarbosa.details.domain.usecase.GetCardInfo
import com.luanabarbosa.details.domain.usecase.GetCardInfoUseCase
import com.luanabarbosa.details.ui.DetailsCardViewModel
import com.luanabarbosa.network.retrofit.NetworkInicialization
import org.koin.dsl.module

val detailsModule = module {
    single { NetworkInicialization().createService(DetailsApi::class.java) }
    single<DetailsRepository> { AppDetailsRepository(get(), get()) }
    single<GetCardInfoUseCase> { GetCardInfo(get()) }
    single { DetailsCardViewModel(get()) }
    single<DetailsMapper> { DetailsMapperImpl() }
}
