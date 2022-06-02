package com.luanabarbosa.details.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.luanabarbosa.details.R
import com.luanabarbosa.details.data.model.CoreDetailsModel
import com.luanabarbosa.details.databinding.FragmentDetailsCardBinding
import com.luanabarbosa.network.response.ApiResponse
import com.luanabarbosa.toolkit.extensions.gone
import com.luanabarbosa.toolkit.extensions.load
import com.luanabarbosa.toolkit.extensions.onBackPressed
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class DetailsCardFragment : Fragment() {

    private lateinit var binding: FragmentDetailsCardBinding
    private lateinit var cardDetails: CoreDetailsModel
    private val cardViewModel: DetailsCardViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsCardBinding.inflate(
            LayoutInflater.from(context),
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getString("cardId")?.let {
            setupObserver()
            setupListeners()
            cardViewModel.loadCardInfo(it)
            binding.toolbar.apply {
                inflateMenu(R.menu.details_menu);
                setOnMenuItemClickListener {
                    when (it.itemId) {
                        R.id.action_share -> shareEvent()
                    }
                    true
                }
            }

        }
    }

    private fun updateInfoCard(cards: CoreDetailsModel) {
        with(binding) {
            cardDetails = cards
            nameCard.text = cards.name
            setCard.text = getString(R.string.text_set, cards.cardSet)
            typeCard.text = getString(R.string.text_type, cards.type)
            factionCard.text = getString(R.string.text_faction, cards.faction)
            rarityCard.text = getString(R.string.text_rarity, cards.rarity)
            attackCard.text = getString(R.string.text_attack, cards.attack)
            costCard.text = getString(R.string.text_cost, cards.cost)
            healthCard.text = getString(R.string.text_health, cards.health)
            descriptionFlavor.text = getString(R.string.text_flavor, cards.flavor)
            descriptionShort.text = cards.text
            imageCard.load(cards.img)
        }
    }

    private fun setupObserver() {
        cardViewModel.cardsDetailsInfo.observe(viewLifecycleOwner) {
            when (it) {
                is ApiResponse.Success -> {
                    binding.loading.gone()
                    updateInfoCard(it.data)
                }
            }
        }
    }

    private fun setupListeners() {
        binding.toolbar.setOnClickListener {
            onBackPressed()
        }
    }

    private fun shareEvent() {
        startActivity(
            Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(
                    Intent.EXTRA_TEXT,
                    getString(R.string.text_share, cardDetails.img)
                )
//                type = "text/plain"
            }
        )
    }
}