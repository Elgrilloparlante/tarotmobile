package com.elgrilloparlante.tarotmobile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.elgrilloparlante.tarotmobile.adapters.CardsAdapter
import com.elgrilloparlante.tarotmobile.models.Card

class CardsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 3) // 3 columns grid

        val cardList = prepareCardList() // Create a list of Card objects
        val adapter = CardsAdapter(cardList)
        recyclerView.adapter = adapter
    }

    private fun prepareCardList(): List<Card> {
        val cardList = mutableListOf<Card>()
        for (i in 1..22) {
            val cardImageName = "card$i"
            val cardImageId = resources.getIdentifier(cardImageName, "drawable", packageName)
            if (cardImageId != 0) {
                cardList.add(Card(cardImageId))
            }
        }
        return cardList
    }
}

