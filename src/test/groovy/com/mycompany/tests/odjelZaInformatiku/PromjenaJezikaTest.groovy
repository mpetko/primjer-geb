package com.mycompany.tests.odjelZaInformatiku

import com.mycompany.component.library.odjelZaInformatikuKomponente.OdjelZaInfEngleskiHomePage
import com.mycompany.component.library.odjelZaInformatikuKomponente.OdjelZaInfHomePage
import geb.spock.GebReportingSpec
import spock.lang.Stepwise

@Stepwise
class PromjenaJezikaTest extends GebReportingSpec {
   private static final String ENGLESKA_PORUKA_DOBRODOSLICE = "Welcome to the Department of Informatics official website!"

   def "Promjena jezika na web stranici Odjela za informatiku"() {
      when: "Otvaranje naslovne stranice Odjela za informatiku"
      to OdjelZaInfHomePage

      then: "Provjera otvorene stranice - inf.uniri.hr"
      at OdjelZaInfHomePage

      when: "Klik na englesku zastavu za promjenu jezika"
      engleskiJezikZastava.click()

      then: "Provjera otvorene stranice - inf.uniri.hr/en i poruke dobrodošlice"
      at OdjelZaInfEngleskiHomePage

      def porukaDobrodoslice = porukaDobrodoslice1.text() + " " + porukaDobrodoslice2.text()
      porukaDobrodoslice == ENGLESKA_PORUKA_DOBRODOSLICE
   }
}
