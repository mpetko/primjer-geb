package com.mycompany.component.library.webAplikacijaKomponente

import geb.Page

import static com.mycompany.Config.CONFIG

class WebAppLoginPage extends Page {
   private static final NASLOV = "Mario Petkovic | Diplomski - Prijava"

   static url = "http://${CONFIG.webAppServer}"
   static at = { title == NASLOV }
   static atCheckWaiting = true

   static content = {
      inputEmail(wait:true) { $('input', name: 'user_email') }
      inputPassword(wait:true) { $('input', name: 'password') }

      buttonPrijava(wait:true) { $('button', name: 'btn-login') }

      porukaPogreske(wait:true) { $('.alert-danger') }
   }
}
