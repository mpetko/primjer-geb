package com.mycompany.component.library.odjelZaInformatikuKomponente

import geb.Page

import static com.mycompany.Config.CONFIG

class OdjelZaInfHomePage extends Page {
   private static final ODJEL_ZA_INF_NASLOV = "Odjel za informatiku - Naslovnica"
   private static final O_ODJELU_LINK = "O odjelu"

   static url = "http://${CONFIG.urlOdjelZaInf}"
   static at = { title == ODJEL_ZA_INF_NASLOV }
   static atCheckWaiting = true

   static content = {
      oOdjeluLink(wait: true) { $('a', text: iContains(O_ODJELU_LINK)) }

      engleskiJezikZastava(wait: true) { $('.mod-languages').$('a', href: '/en/') }
   }
}
