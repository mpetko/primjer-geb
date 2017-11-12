package com.mycompany.tests.webAplikacija

import com.mycompany.component.library.webAplikacijaKomponente.WebAppHomePage
import com.mycompany.component.library.webAplikacijaKomponente.WebAppProfilPage
import com.mycompany.component.library.webAplikacijaKomponente.WebAppLoginPage
import geb.spock.GebReportingSpec
import spock.lang.Stepwise

@Stepwise
class UserJourneyWebAppTest extends GebReportingSpec {
   private static final EMAIL = "admin@mail.com"
   private static final NEISPARVNA_LOZINKA = "pas"
   private static final ISPRAVNA_LOZINKA = "password"
   private static final NOVA_LOZINKA = "password123"

   def "User journey test web apliakcije"() {
      given: "Stranica za prijavu trebala bi se prikazatii"
      WebAppLoginPage webAppLoginPage = browser.to(WebAppLoginPage)

      when: "Korisnik unosi e-mail i neispravnu lozinku"
      webAppLoginPage.inputEmail.value(EMAIL)
      webAppLoginPage.inputEmail.value() == EMAIL

      webAppLoginPage.inputPassword.value(NEISPARVNA_LOZINKA)
      webAppLoginPage.inputPassword.value() == NEISPARVNA_LOZINKA

      and: "Klik na gumb za prijavu"
      webAppLoginPage.buttonPrijava.click()

      then: "Prikaz poruke za neispravan emial/lozinku"
      webAppLoginPage.porukaPogreske.isDisplayed()

      when: "Korisnik unosi ispravnu lozinku"
      webAppLoginPage.inputPassword.value(ISPRAVNA_LOZINKA)
      webAppLoginPage.inputPassword.value() == ISPRAVNA_LOZINKA

      and: "Klik na gumb za prijavu"
      webAppLoginPage.buttonPrijava.click()

      then: "Početna stranica aplikacije i poruka dobrodoslice trebale bi se prikazati"
      WebAppHomePage webAppHomePage = browser.at(WebAppHomePage)
      webAppHomePage.porukaUspjesnePrijave.isDisplayed()

      when: "Klik na padajući izbornik i zatim Profil"
      webAppHomePage.navigacijskaTraka.dropDownMeni.click()

      and: "Klik na Profil"
      webAppHomePage.navigacijskaTraka.profil.click()

      then: "Korisnički profil trebao bi se prikazati"
      WebAppProfilPage webAppProfilPage = browser.at(WebAppProfilPage)

      when: "Korisnik unosi novu lozinku"
      webAppProfilPage.poljeLozinka.value(NOVA_LOZINKA)
      webAppProfilPage.poljeLozinka.value() == NOVA_LOZINKA

      and: "Klik na gumb Spremi"
      webAppProfilPage.spremiGumb.click()

      then: "Obavijest o azuriranju profila trebao bi biti prikazan"
      webAppProfilPage.porukaUpjeha.isDisplayed()

      when: "Klik na gumb za povratak na početnu stranicu"
      waitFor {
         webAppProfilPage.navigacijskaTraka.backButton.click()
      }

      then: "Početna stranica aplikacije trebala bi se prikazati"
      browser.at(WebAppHomePage)

      when: "Klik na 'Ispuni upitnik' gumb"
      webAppHomePage.ispuniUpitnikGumb.click()

      then: "Modalni prozor upitnika trebao bi se prikazati"
      waitFor {
      webAppHomePage.modalniUpitnik.isDisplayed()
      }

      when: "Korisnik popunjava upitnik"
      webAppHomePage.imeUpitnik.value("Mario")
      webAppHomePage.prezimeUpitnik.value("Petkovic")

      webAppHomePage.spolUpitnik.click()

      webAppHomePage.gradPoljeUpitnik.click()
      webAppHomePage.drugiGradNaListiUpitnik.click()

      webAppHomePage.voziloUpitnik.click()

      webAppHomePage.KomentarUpitnik.value("Nemam komentar")

      and: "Klik na gumb za slanje ispunjenog upitnika"
      webAppHomePage.posaljiUpitnikGumb.click()

      then: "Poruka zahvale trebala bi se prikazati"
      webAppHomePage.porukaZahvale.isDisplayed()

      when: "Korisnik se odjavljuje iz aplikacije"
      waitFor {
         webAppHomePage.navigacijskaTraka.dropDownMeni.click()
         webAppHomePage.navigacijskaTraka.signOut.click()
      }

      then: "Stranica za prijavu trebala bi se priakzati"
      browser.at(WebAppLoginPage)

      when: "Korisnik isprobava prijavu s novom lozinkom"
      webAppLoginPage.inputEmail.value(EMAIL)
      webAppLoginPage.inputEmail.value() == EMAIL

      webAppLoginPage.inputPassword.value(NOVA_LOZINKA)
      webAppLoginPage.inputPassword.value() == NOVA_LOZINKA

      and: "Klik na gumb za prijavu"
      webAppLoginPage.buttonPrijava.click()

      then: "Početna stranica aplikacije i poruka dobrodoslice trebale bi se prikazati"
      browser.at(WebAppHomePage)
      webAppHomePage.porukaUspjesnePrijave.isDisplayed()
   }

   def cleanupSpec() {
      WebAppHomePage webAppHomePage = browser.at(WebAppHomePage)
      webAppHomePage.navigacijskaTraka.dropDownMeni.click()
      webAppHomePage.navigacijskaTraka.profil.click()

      WebAppProfilPage webAppProfilPage = browser.at(WebAppProfilPage)
      webAppProfilPage.poljeLozinka.value(ISPRAVNA_LOZINKA)
      webAppProfilPage.spremiGumb.click()
   }
}


