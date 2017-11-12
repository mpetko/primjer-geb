package com.mycompany.component.library.webAplikacijaKomponente

import geb.Module

class WebAppNavigacijskaTrakaModule extends Module {
   static at = { navigacijskaTraka.isDisplayed() }
   static atCheckWaiting = true

   static content = {
      navigacijskaTraka(wait:true) { $('nav', '.navbar-fixed-top') }

      dropDownMeni(wait:true) { $('.dropdown-toggle') }

      profil(wait:true) { $('a', text: iContains('Profil')) }
      signOut(wait:true) { $('a', text: iContains('Sign Out')) }

      backButton(wait:true) { $('button', class: 'btn btn-primary btn-lg navbar-btn pull-left') }
   }
}
