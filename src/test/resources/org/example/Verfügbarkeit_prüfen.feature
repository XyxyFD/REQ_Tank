Feature: Verfügbarkeit prüfen
  Als Kunde möchte ich die Verfügbarkeit von Ladestationen in Echtzeit prüfen können, um sicherzustellen, dass eine Station frei ist, bevor ich dort ankomme.

  Background:
    Given der Kunde ist auf der Seite „Standorte“ eingeloggt
    And der Kunde hat Zugriff auf die Standortliste mit Ladestationen

  Scenario: Verfügbarkeit einer Ladestation anzeigen
    When der Kunde einen Standort aus der Liste auswählt
    Then sollte die Verfügbarkeit aller Ladestationen dieses Standorts angezeigt werden
    And jede Ladestation sollte den Status „frei“, „besetzt“ oder „außer Betrieb“ anzeigen

  Scenario: Typ überprüfen (AC oder DC)
    Given die Liste der Ladestationen ist sichtbar
    When der Kunde eine Ladestation aus der Lister auswähltd
    Then sollten nur die Ladestationen angezeigt werden, die als „frei“ markiert sind
    And die Anzahl verfügbarer Ladestationen sollte oberhalb der Liste sichtbar sein

  Scenario: Aktualisierung der Verfügbarkeit in Echtzeit
    Given die Liste der Ladestationen ist sichtbar
    When die Verfügbarkeit einer Ladestation sich ändert (z. B. wird „besetzt“)
    Then sollte der Status der Ladestation in der Liste sofort aktualisiert werden
    And der Kunde sollte eine Benachrichtigung „Verfügbarkeit aktualisiert“ erhalten

  Scenario: Verfügbarkeit einer spezifischen Ladestation anfragen
    Given der Kunde befindet sich auf der Detailseite einer spezifischen Ladestation
    When der Kunde auf die Schaltfläche „Verfügbarkeit prüfen“ klickt
    Then sollte die aktuelle Verfügbarkeit der Ladestation angezeigt werden
    And der Kunde sollte eine Meldung erhalten, ob die Ladestation „frei“ oder „besetzt“ ist

  Scenario: Keine verfügbare Ladestation am Standort
    Given der Kunde sucht nach einem Standort in der Nähe
    And alle Ladestationen an diesem Standort sind „besetzt“
    When der Kunde die Seite „Verfügbarkeit“ öffnet
    Then sollte eine Meldung „Momentan keine freien Ladestationen verfügbar“ angezeigt werden
    And der Kunde sollte die Möglichkeit haben, eine Benachrichtigung zu aktivieren, wenn eine Station frei wird