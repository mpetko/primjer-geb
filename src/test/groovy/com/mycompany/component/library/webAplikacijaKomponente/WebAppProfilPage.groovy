package com.mycompany.component.library.webAplikacijaKomponente

import geb.Page

class WebAppProfilPage extends Page {
   private static final NASLOV = "Mario Petkovic | Diplomski - Profil"

   static at = { title == NASLOV }
   static atCheckWaiting = true

   static content = {
      poljeLozinka(wait:true) { $('input', name: 'user_password') }
      spremiGumb(wait:true) { $('button', text: iContains('Spremi') ) }

      porukaUpjeha(wait:true) { $('div', id: 'toast_message', text: iContains("Vaš profil je ažuriran") ) }

      navigacijskaTraka { module WebAppNavigacijskaTrakaModule }
   }
}

