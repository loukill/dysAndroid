package tn.esprit.green_world.interfaces

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query
import tn.esprit.green_world.models.Favproduit
import tn.esprit.green_world.models.Produit

interface ProduitfavApi {

    @POST("favproduit/add-products")
    fun addProductToFav(@Query("produitId")produitId: String): Call<Favproduit>
    @GET("favproduit/favorites")
    fun getProduitFav(): Call<Favproduit>
    @DELETE("favproduit/delete-product")
    fun deleteProduitFromFav(@Query("produitId") produitId: String): Call<Favproduit>

}
