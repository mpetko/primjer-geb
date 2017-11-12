package com.mycompany.component.library.webAplikacijaKomponente

import geb.Page

class WebAppHomePage extends Page {
   private static final NASLOV = "Mario Petkovic | Diplomski - Pocetna"

   static at = { title == NASLOV }
   static atCheckWaiting = true

   static content = {
      porukaUspjesnePrijave(wait:true) { $('.alert-success', text: iContains('Dobrodosao')) }

      ispuniUpitnikGumb(wait:true) { $('button', text: iContains('Ispuni upitnik')) }

      modalniUpitnik(wait:true) { $('form', id:'mojaForma') }

      imeUpitnik(wait:true) { $('input', name: 'imekorisnika') }
      prezimeUpitnik(wait:true) { $('input', name: 'prezimekorisnika') }
      spolUpitnik(wait:true) { $('input',1, name: 'spol') }
      gradPoljeUpitnik(wait:true) { $('select', name: 'grad') }
      drugiGradNaListiUpitnik(wait:true) { $('select', name: 'grad').$('option', 1) }
      voziloUpitnik(wait:true) { $('input', 0, name: 'vozilo') }
      KomentarUpitnik(wait:true) { $('textarea') }

      posaljiUpitnikGumb(wait:true) { $('button', text: iContains('Pošalji')) }

      porukaZahvale(wait:true) { $('div', id: 'toast_message', text: iContains("Hvala na odgovorima!") ) }

      navigacijskaTraka { module WebAppNavigacijskaTrakaModule }
   }
}
