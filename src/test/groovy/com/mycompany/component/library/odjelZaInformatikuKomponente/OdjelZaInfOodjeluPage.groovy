package com.mycompany.component.library.odjelZaInformatikuKomponente

import geb.Page

class OdjelZaInfOodjeluPage extends Page {
   private static final ODJEL_ZA_INF_NASLOV = "Odjel za informatiku - O odjelu"

   private static final ADRESA = "Radmile Matejčić 2"
   private static final TELEFON = "+ 385 51 584 700"
   private static final EMAIL = "ured@inf.uniri.hr"
   private static final IBAN = "HR0423600001400485134"
   private static final OIB = "64218323816"

   static at = { title == ODJEL_ZA_INF_NASLOV }
   static atCheckWaiting = true

   static content = {
      adresaOdjela(wait:true) { $('.item-page').$('div', text: iContains(ADRESA)) }
      telefonOdjela(wait:true) { $('.item-page').$('div', text: iContains(TELEFON)) }
      emailOdjela(wait:true) { $('.item-page').$('div', text: iContains(EMAIL)) }
      ibanOdjela(wait:true) { $('.item-page').$('span', text: iContains(IBAN)) }
      oibOdjela(wait:true) { $('.item-page').$('span', text: iContains(OIB)) }
   }

   def provjeraOsnovnihPodataka() {
      adresaOdjela.isDisplayed()
      telefonOdjela.isDisplayed()
      emailOdjela.isDisplayed()
      ibanOdjela.isDisplayed()
      oibOdjela.isDisplayed()
   }
}
