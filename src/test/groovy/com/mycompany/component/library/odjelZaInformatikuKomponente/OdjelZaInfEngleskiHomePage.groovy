package com.mycompany.component.library.odjelZaInformatikuKomponente

import geb.Page

import static com.mycompany.Config.CONFIG

class OdjelZaInfEngleskiHomePage extends Page {
   private static final ODJEL_ZA_INF_NASLOV = "Odjel za informatiku - Home page"

   static url = "http://${CONFIG.urlOdjelZaInfEng}"
   static at = { title == ODJEL_ZA_INF_NASLOV }
   static atCheckWaiting = true

   static content = {
      porukaDobrodoslice1(wait:true) { $('span', id: 'result_box').$('span', class: 'hps', 0) }
      porukaDobrodoslice2(wait:true) { $('span', id: 'result_box').$('span', class: 'hps', 1) }
   }
}
