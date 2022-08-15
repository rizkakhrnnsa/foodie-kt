package com.rizka.foodie.data

object FoodieData {
    private val foodieImages = arrayOf(
        "https://cdn-2.tstatic.net/tribunnews/foto/bank/images/tips-pasti-jadi-bikin-rendang-pakai-rice-cooker.jpg"
    )

    private val foodieNames = arrayOf(
        "Rendang"
    )

    private val foodieDescription = arrayOf(
        "Rendang adalah makanan internasional yang berasal dari indonesia. Makanan yang berasal dari daerah Minangkabau ini bisa dikatakan sangat mudah untuk dibuat. Pada tahun 2011 silam, rendang atau sering juga disebut randang masuk dalam 50 makanan paling enak di dunia versi CNN."
    )

    private val foodieCountryOrigins = arrayOf(
        "Indonesia"
    )

    val foodieList: ArrayList<Foodie>
    get() {
        val data = arrayListOf<Foodie>()
        for (position in foodieNames.indices) {
            val foodie = Foodie()
            foodie.imageFoodie = foodieImages[position]
            foodie.nameFoodie = foodieNames[position]
            foodie.descriptionFoodie = foodieDescription[position]
            foodie.countryOriginFoodie = foodieCountryOrigins[position]
            data.add(foodie)
        }
        return data
    }
}