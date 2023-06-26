# Emotes
Ein simples Emotes-Plugin für Minecraft Spigot/Paper 1.20

Es ist simpel:
Lade das Plugin auf deinen Spigot/Paper Server der Version 1.20 und es erstellt sich bei Start eine Konfiguration. In dieser wird, falls kein gültiges Emote eingestellt, ein Testemote vorhanden sein.

Die Konfig ist folgendermaßen aufgebaut:

```
emotes:
    NAME_DES_EMOTES:
        char: "Emote"
```

In jeder Nachricht eines Spielers wird dann ":NAME_DES_EMOTES:" durch "Emote", also das ersetzende Zeichen, ersetzt.

Eine Liste aller Emotes mit zugehörigen Namen kann über /emotes oder /e abgerufen werden.
