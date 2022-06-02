package com.luanabarbosa.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.core.net.toUri
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.luanabarbosa.home.data.model.CoreModel
import com.luanabarbosa.home.databinding.FragmentHomeCardListBinding
import com.luanabarbosa.home.ui.adapter.HomeCardAdapter
import com.luanabarbosa.toolkit.extensions.gone
import com.luanabarbosa.toolkit.extensions.visible
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class HomeCardFragment : Fragment() {
    private lateinit var binding: FragmentHomeCardListBinding
    private val cardsViewModel: HomeCardViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeCardListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
        refreshScreen()
        setupErrorScreen()
        loadGetCards()
    }

    private fun loadGetCards() {
        with(binding) {
            containerSuccess.visible()
            errorContainer.gone()
        }
        cardsViewModel.getHomeCards()
    }

    private fun refreshScreen() = with(binding) {
        containerSwipe.setOnRefreshListener {
            rvList.gone()
            loading.visible()
            loadGetCards()
            containerSwipe.isRefreshing = false
        }
    }

    private fun setupErrorScreen() {
        with(binding) {
            button.setOnClickListener {
                loadGetCards()
            }
        }
    }

    private fun setupObserver() {
        cardsViewModel.observerCards(this) {
            setupAdapter(it)
            searchListDisplay(it)
        }

        cardsViewModel.error.observe(viewLifecycleOwner) {
            with(binding) {
                containerSuccess.gone()
                errorContainer.visible()
            }
        }
    }

    private fun setupAdapter(list: List<CoreModel>) {
        with(binding) {
            rvList.visible()
            searchBar.visible()
            loading.gone()
            rvList.layoutManager = GridLayoutManager(context, 2)
            rvList.adapter =
                HomeCardAdapter(list.filter { it.name.isNotEmpty()
                        && it.cardSet.isNotEmpty()
                        && it.flavor.isNotEmpty()
                        && it.text.isNotEmpty()
                        && it.type.isNotEmpty()
                        && it.faction.isNotEmpty()
                        && it.rarity.isNotEmpty()
                        && it.attack.isNotEmpty()
                        && it.cost.isNotEmpty()
                        && it.health.isNotEmpty()
                        && it.img.isNotEmpty() }) {
                    navigate(it)
                }
        }
    }

    private fun searchListDisplay(list: List<CoreModel>) {
        binding.searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                resultListSearch(query, list)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                resultListSearch(newText, list)
                return false
            }
        })
    }

    private fun resultListSearch(search: String, list: List<CoreModel>) {
        val lisResultSearch: MutableList<CoreModel> = arrayListOf()
        for (element in list) {
            if (element.name.contains(search, ignoreCase = true)) {
                lisResultSearch.add(element)
            }
        }
        setupAdapter(lisResultSearch)
    }

    private fun navigate(homeCards: CoreModel) {
        findNavController().apply {
            this.graph.find { navDestination ->
                navDestination.hasDeepLink(DETAILS_FRAGMENT.toUri())
            }?.let {
                this.navigate(it.id, bundleOf("cardId" to homeCards.cardId))
            }
        }
    }

    companion object {
        const val DETAILS_FRAGMENT = "app://DETAILS_SCREEN"
    }
}
