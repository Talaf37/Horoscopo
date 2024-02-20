package com.example.horoscopo_app.data

import com.example.horoscopo_app.R
sealed class Horoscopo (val id:String, val image:Int, val name:Int) {
    object Aries : Horoscopo("Aries",R.drawable.aries, R.string.horoscopo_name_aries)
    object Taurus: Horoscopo("Taurus",R.drawable.taurus, R.string.horoscopo_name_taurus)
    object Gemini: Horoscopo("Gemini",R.drawable.gemini, R.string.horoscopo_name_gemini)
    object Cancer: Horoscopo("Cancer",R.drawable.cancer, R.string.horoscopo_name_cancer)
    object Leo: Horoscopo("Leo",R.drawable.leo, R.string.horoscopo_name_leo)
    object Virgo: Horoscopo("Virgo",R.drawable.virgo, R.string.horoscopo_name_virgo)
    object Libra: Horoscopo("Libra",R.drawable.libra, R.string.horoscopo_name_libra)
    object Scorpio: Horoscopo("Scorpio",R.drawable.scorpio, R.string.horoscopo_name_scorpio)
    object Sagittarius: Horoscopo("Sagittarius",R.drawable.sagittarius, R.string.horoscopo_name_sagittarius)
    object Capricorn: Horoscopo("Capricorn",R.drawable.capricorn, R.string.horoscopo_name_capricorn)
    object Aquarius: Horoscopo("Aquarius",R.drawable.aquarius, R.string.horoscopo_name_aquarius)
    object Pisces: Horoscopo("Pisces",R.drawable.pisces, R.string.horoscopo_name_pisces)
}