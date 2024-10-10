Feature: Preisübersicht einsehen
  Als Kunde möchte ich die Preisübersicht für die verschiedenen Ladetarife einsehen können, um die Kosten für meine Nutzung vorab zu verstehen.

  Background:
    Given der Kunde ist eingeloggt
    And der Kunde befindet sich auf der Seite „Standorte“

  Scenario: Preisübersicht für einen Standort anzeigen
    When der Kunde einen Standort aus der Liste auswählt
    And auf die Schaltfläche „Preisübersicht anzeigen“ klickt
    Then sollte die Preisübersicht für diesen Standort angezeigt werden
    And die Preise sollten nach Ladearten (z.B. AC, DC) und Tarifoptionen aufgeschlüsselt sein

  Scenario: Preisübersicht für verschiedene Ladearten anzeigen
    Given die Preisübersicht für einen Standort ist sichtbar
    When der Standort sowohl AC- als auch DC-Ladepunkte bietet
    Then sollte die Preisübersicht die Preise für AC- und DC-Laden getrennt anzeigen
    And jede Ladeart sollte den Preis pro kWh und gegebenenfalls eine Startgebühr angeben

  Scenario: Preisdetails einer spezifischen Tarifoption anzeigen
    Given die Preisübersicht für einen Standort ist sichtbar
    When der Kunde eine spezifische Tarifoption (z. B. „Schnellladen DC“) auswählt
    Then sollten die Details dieser Tarifoption angezeigt werden
    And die Details sollten den Preis pro kWh, die Startgebühr und mögliche zusätzliche Gebühren umfassen