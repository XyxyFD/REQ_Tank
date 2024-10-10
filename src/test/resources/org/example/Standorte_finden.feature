Feature: Standorte finden
  Als Kunde möchte ich Standorte wie Tankstellen oder Ladestationen finden können, um die für mich nächstgelegene oder passende Station zu nutzen.

  Background:
    Given der Kunde ist auf der Startseite der App eingeloggt
    And die App hat Zugriff auf den Standort des Kunden

  Scenario: Nächstgelegene Standorte anzeigen
    When der Kunde die Funktion „Standorte in meiner Nähe finden“ aktiviert
    Then sollten alle nahegelegenen Standorte in einer Liste und auf einer Karte angezeigt werden
    And jeder Standort sollte den Namen, die Entfernung und die Öffnungszeiten anzeigen

  Scenario: Standorte an einem bestimmten Ort suchen
    When der Kunde in das Suchfeld einen Ort (z. B. „Berlin“) eingibt
    And auf die Schaltfläche „Suchen“ klickt
    Then sollten alle Standorte in und um Berlin angezeigt werden
    And die Liste und Karte sollten die jeweiligen Standorte mit Namen und Entfernung vom eingegebenen Ort anzeigen

  Scenario: Filter nach Ausstattung anwenden
    Given die Liste der Standorte ist sichtbar
    When der Kunde die Filteroption „Nur Ladestationen mit DC-Ladesäulen“ auswählt
    Then sollten nur Standorte mit DC-Ladesäulen angezeigt werden
    And die Anzahl gefilterter Standorte sollte oben in der Liste sichtbar sein



