package com.example.horoscopo_app.data

import com.example.horoscopo_app.R
sealed class Horoscopo (val id:String, val image:Int, val name:Int, val dates:Int) {
    object Aries : Horoscopo("Aries",R.drawable.aries, R.string.horoscopo_name_aries, R.string.horoscopo_date_aries)
    object Taurus: Horoscopo("Taurus",R.drawable.taurus, R.string.horoscopo_name_taurus, R.string.horoscopo_date_tauro)
    object Gemini: Horoscopo("Gemini",R.drawable.gemini, R.string.horoscopo_name_gemini, R.string.horoscopo_date_gemini)
    object Cancer: Horoscopo("Cancer",R.drawable.cancer, R.string.horoscopo_name_cancer, R.string.horoscopo_date_cancer)
    object Leo: Horoscopo("Leo",R.drawable.leo, R.string.horoscopo_name_leo, R.string.horoscopo_date_leo)
    object Virgo: Horoscopo("Virgo",R.drawable.virgo, R.string.horoscopo_name_virgo, R.string.horoscopo_date_virgo)
    object Libra: Horoscopo("Libra",R.drawable.libra, R.string.horoscopo_name_libra, R.string.horoscopo_date_libra)
    object Scorpio: Horoscopo("Scorpio",R.drawable.scorpio, R.string.horoscopo_name_scorpio, R.string.horoscopo_date_escorpio)
    object Sagittarius: Horoscopo("Sagittarius",R.drawable.sagittarius, R.string.horoscopo_name_sagittarius, R.string.horoscopo_date_sagitario)
    object Capricorn: Horoscopo("Capricorn",R.drawable.capricorn, R.string.horoscopo_name_capricorn, R.string.horoscopo_date_capricornio)
    object Aquarius: Horoscopo("Aquarius",R.drawable.aquarius, R.string.horoscopo_name_aquarius, R.string.horoscopo_date_acuario)
    object Pisces: Horoscopo("Pisces",R.drawable.pisces, R.string.horoscopo_name_pisces, R.string.horoscopo_date_piscis)
}