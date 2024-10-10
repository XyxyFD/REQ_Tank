Feature: Ladevorgang starten
  Als Kunde möchte ich einen Ladevorgang an einer Ladestation starten können, um mein Fahrzeug aufzuladen.

  Background:
    Given die Ladestation ist betriebsbereit
    And der Kunde ist erfolgreich mit seiner Kunden-ID an der Ladestation identifiziert

  Scenario: Automatischer Start des Ladevorgangs nach Identifikation
    Given die Option „Automatischer Start“ ist in den Einstellungen des Kunden aktiviert
    When der Kunde erfolgreich identifiziert wird
    Then sollte der Ladevorgang automatisch starten
    And der Kunde sollte eine Benachrichtigung „Ladevorgang erfolgreich gestartet“ erhalten

  Scenario: Fehlermeldung bei besetztem Ladeanschluss
    Given alle Ladeanschlüsse der Ladestation sind besetzt
    When der Kunde versucht, den Ladevorgang zu starten
    Then sollte eine Fehlermeldung „Ladevorgang kann nicht gestartet werden – alle Anschlüsse sind besetzt“ angezeigt werden
    And der Kunde sollte die Option haben, eine Benachrichtigung zu aktivieren, wenn ein Ladeanschluss frei wird

  Scenario: Ladevorgang ohne ausreichendes Guthaben starten
    Given das Guthaben des Kunden ist nicht ausreichend für den Ladevorgang
    When der Kunde versucht, den Ladevorgang zu starten
    Then sollte eine Fehlermeldung „Unzureichendes Guthaben. Bitte laden Sie Ihr Konto auf.“ angezeigt werden
    And der Ladevorgang sollte nicht beginnen