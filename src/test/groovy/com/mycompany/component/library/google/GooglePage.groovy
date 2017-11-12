package com.mycompany.component.library.google

import geb.Page
import static com.mycompany.Config.CONFIG

class GooglePage extends Page {
   static url = "http://${CONFIG.server}"
   static at = { title == "Google" }
   static atCheckWaiting = true

   static content = {
      searchBar(wait: true) { $('input', id: 'lst-ib') }

      prviRezultatPretrage(wait: true) { $('div', id: 'ires').$('a', 0) }
   }
}
