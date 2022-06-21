package me.thiagorigonatti.getspawners.customconfig;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class BrazilianPortugueseContent {
    private static Writer writer;

    static void writePtbrMessagesContent(Path messagesEnFile) {
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(messagesEnFile.toFile()), StandardCharsets.UTF_8));
            writer.write("# Se você quiser alterar qualquer linha de qualquer arquivo desse plugin, se o primeiro caractere\n" +
                    "# for começar com '&', coloque dentro de aspas simples \"' '\" ex: '&aIniciado com sucesso!'\n" +
                    "\n" +
                    "Plugin:\n" +
                    "# Este é o prefíxo que irá aparecer sempre que o plugin enviar uma mensagem\n" +
                    "  Prefix: '&f[&eGet&3Spawners&f]'\n" +
                    "  \n" +
                    "Console_Messages:\n" +
                    "# Mensagem que aparece quando o plugin é iniciado\n" +
                    "  Plugin_Enabled: '&aIniciado com sucesso!'\n" +
                    "  \n" +
                    "# Mensagem enviada para quem recarregou o plugin, quando o mesmo é recarregado\n" +
                    "  Plugin_Reloaded: '&aRecarregado com sucesso!'\n" +
                    "  \n" +
                    "Messages:\n" +
                    "# Esta mensagem aparece quando um jogador quem possui permissões de porcentagem de chance de\n" +
                    "# dropar geradores, minera um gerador e tem a sorte de dropá-lo\n" +
                    "  Lucky: '&bBoa, Sortudo ! ! !'\n" +
                    "  \n" +
                    "# Esta mensagem aparece quando um jogador quem possui permissões de porcentagem de chance de\n" +
                    "# dropar geradores, minera um gerador, é azarado e não dropa um gerador\n" +
                    "  Unlucky: '&cMais sorte da próxima vez.'\n" +
                    "  \n" +
                    "# Esta mensagem irá ser exibida ao jogador que tentar dropar um gerador sem a ferramenta\n" +
                    "# correta permitida\n" +
                    "  Warning: '&cVocê não pode dropar geradores com esse tipo de ferramenta.'\n" +
                    "  \n" +
                    "# Quando o jogador não tiver permissão para realizar uma ação com geradores\n" +
                    "# esta é a mensagem a ser exibida\n" +
                    "  No_Permission: '&cVocê não tem permissão para fazer isso.'\n" +
                    "  \n" +
                    "# Quando o jogador não tiver permissão para dropar um tipo de gerador específico, essa é a\n" +
                    "# mensagem a ser exibida\n" +
                    "  No_Mob_Permission: '&cVocê não tem permissão para dropar um %spawner_name%.'\n" +
                    "  \n" +
                    "# Se você tentar enviar um gerador para um player que não está online no servidor, esta\n" +
                    "# mensagem será enviada\n" +
                    "  Player_Not_Found: '&cO jogador não foi encontrado online no servidor.'\n" +
                    "  \n" +
                    "# Mensagem de comando inválido\n" +
                    "  Invalid_Command: '&cComando inválido: &6Uso: /gs give <jogador> <tipo_de_gerador> <quantidade>'\n" +
                    "  \n" +
                    "# Mensagem de gerador enviado por comando com sucesso\n" +
                    "  Gave: '&aVocê deu &6%amount%&r %spawner_name% &apara &f%player%.'\n" +
                    "  \n" +
                    "# Mensagem de gerador recebido através de comando com sucesso\n" +
                    "  Received: '&aVocê recebeu &6%amount%&r %spawner_name% &ade &f%sender%.'\n" +
                    "  \n" +
                    "# Nomes dos tipos de geradores disponíveis\n" +
                    "  Mob_Names: '&eTipos de geradores:'\n" +
                    "  \n" +
                    "# Dica de comandos disponíveis\n" +
                    "  Commands_Hint: '&eComandos disponíveis:'\n" +
                    "  \n" +
                    "# A mensagem que anuncia a troca de tipo de um gerador através de um ovo\n" +
                    "  Changed_Spawner: '&fAlterado %placed_spawner% &fpara %new_spawner%.'\n" +
                    "  \n" +
                    "# Se a opção de alterar tipos de geradores estiver desativada, essa mensagem irá avisá-lo\n" +
                    "  No_Change_Enabled: '&cVocê não pode fazer isso porque a opção de alterar tipos de geradores com ovo está desativada no arquivo config.yml.'\n" +
                    "  \n" +
                    "# Se você tiver o plugin GriefPrevention instalado, essa mensagem\n" +
                    "# irá aparecer para jogadores que tentarem mudar o tipo de gerador com um ovo, em\n" +
                    "# uma área protegida por GriefPrevention em que não tem permissão\n" +
                    "  GriefPrevention_Compat_No_Interact: '&2Área protegida por GriefPrevention; &cVocê não tem permissão para interagir com este bloco.'\n" +
                    "  \n" +
                    "# Se você tiver o plugin Residence instalado, essa mensagem irá aparecer para jogadores que tentarem\n" +
                    "# mudar o tipo de gerador com um ovo, em uma área protegida por Residence em que não tem permissão\n" +
                    "  Residence_Compat_No_Interact: '&6Área protegida por Residence; &cVocê não tem permissão para interagir com este bloco.'\n" +
                    "  \n" +
                    "# Se você tiver o plugin WorldGuard instalado, essa mensagem irá aparecer para jogadores que tentarem\n" +
                    "# mudar o tipo de gerador com um ovo, em uma área protegida por WorldGuard em que não tem permissão\n" +
                    "  WorldGuard_Compat_No_Interact: '&3Área protegida por WorldGuard; &c&lOpa! &7Desculpe, mas você não pode interagir com este bloco.'\n" +
                    "  \n" +
                    "# Se você tiver o plugin WorldGuard instalado, essa mensagem irá aparecer para jogadores que tentarem\n" +
                    "# quebrar o gerador, em uma área protegida por WorldGuard em que não tem permissão\n" +
                    "  WorldGuard_Compat_No_Break: '&3WorldGuard protected area; &c&lHey! &c&lOpa! &7Desculpe, mas você não pode quebrar este bloco.'\n" +
                    "  \n" +
                    "# Se você tiver o plugin Towny instalado, essa mensagem irá aparecer para jogadores que tentarem\n" +
                    "# mudar o tipo de gerador com um ovo, em uma área protegida por Towny em que não tem permissão\n" +
                    "  Towny_Compat_No_Interact: '&5Área protegida por Towny; &cNão é permitido interação com este bloco.'\n" +
                    "  \n" +
                    "# Se você tiver o plugin SuperVanish instalado, essa mensagem irá aparecer para jogadores\n" +
                    "# invisíveis que tentarem mudar o tipo de gerador com um ovo, enquanto a opção\n" +
                    "# SuperVanish_Prevent_SpawnEgg_Change estiver ativada no aquivo config.yml\n" +
                    "  SuperVanish_Compat_No_Interact: '&cVocê não pode alterar geradores enquanto estiver invisível por &aSuperVanish, &cporque esta opção está ativada no arquivo config.yml.'\n" +
                    "  \n" +
                    "# Esta mensagem irá aparecer para jogadores que tentarem empilhar mais geradores do que o\n" +
                    "# limite máximo em um bloco.\n" +
                    "  Stack_Limit_Warning: '&cVocê alcançou o limite máximo ao empilhar geradores.'\n" +
                    "  \n" +
                    "# Esta mensagem irá aparecer quando um jogador emitir o comando gs debug e remover nomes de geradores bugados sem geradores\n" +
                    "  Bug_Removed_Announce: '&eBug removido, o nome %hologram_name% sem um spawner se foi.'\n" +
                    "  \n" +
                    "# Esta mensagem irá aparecer mostrando a quantidade de nomes bugados removidos\n" +
                    "  Bug_Removed_Amount: '&eRemovido &a%amount% &enomes de geradores bugados sem geradores.'\n" +
                    "  \n" +
                    "# Escolha se quer ver quantos exps um monstro gs dropa em sua morte\n" +
                    "Announce_Dropped_Exp:\n" +
                    "  Enabled: false\n" +
                    "# Mensagem a ser exibida para o jogador que matou uma criatura contendo a quantidade de exp dropado\n" +
                    "  Message: '&aMatou &6%mob_name% &a%dropped_exp% exp dropado.'");
            writer.flush();
            writer.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    static void writePtbrSpawnersContent(Path spawnersEnFile) {
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(spawnersEnFile.toFile()), StandardCharsets.UTF_8));
            writer.write("# Leia com atenção\n" +
                    "# Se você quiser alterar qualquer linha de qualquer arquivo, se o primeiro caractere\n" +
                    "# for começar com '&', coloque dentro de aspas simples \"' '\" ex: '&fGerador de Blaze'\n" +
                    "# Você é capaz de alterar o nome dos geradores, mas 2 geradores do mesmo tipo, porém com nomes diferentes\n" +
                    "# não irão se juntar no seu inventário\n" +
                    "Spawner_Name:\n" +
                    "  Allay: '&fGerador de Allay'\n" +
                    "  Axolotl: '&fGerador de Axolote'\n" +
                    "  Bat: '&fGerador de Morcego'\n" +
                    "  Bee: '&fGerador de Abelha'\n" +
                    "  Blaze: '&fGerador de Blaze'\n" +
                    "  Cat: '&fGerador de Gato'\n" +
                    "  Cave_Spider: '&fGerador de Aranha das cavernas'\n" +
                    "  Chicken: '&fGerador de Galinha'\n" +
                    "  Cod: '&fGerador de Bacalhau'\n" +
                    "  Cow: '&fGerador de Vaca'\n" +
                    "  Creeper: '&fGerador de Creeper'\n" +
                    "  Dolphin: '&fGerador de Golfinho'\n" +
                    "  Donkey: '&fGerador de Burro'\n" +
                    "  Drowned: '&fGerador de Afogado'\n" +
                    "  Elder_Guardian: '&fGerador de Guardião mestre'\n" +
                    "  Ender_Dragon: '&fGerador de Dragão do end'\n" +
                    "  Enderman: '&fGerador de Enderman'\n" +
                    "  Endermite: '&fGerador de Endermite'\n" +
                    "  Evoker: '&fGerador de Invocador'\n" +
                    "  Experience_Bottle: '&fGerador de Frasco de experiência'\n" +
                    "  Frog: '&fGerador de Sapo'\n" +
                    "  Fox: '&fGerador de Raposa'\n" +
                    "  Ghast: '&fGerador de Ghast'\n" +
                    "  Giant: '&fGerador de Giant'\n" +
                    "  Glow_Squid: '&fGerador de Lula-Brilhante'\n" +
                    "  Goat: '&fGerador de Cabra'\n" +
                    "  Guardian: '&fGerador de Guardião'\n" +
                    "  Hoglin: '&fGerador de Hoglin'\n" +
                    "  Horse: '&fGerador de Cavalo'\n" +
                    "  Husk: '&fGerador de Zumbi-Múmia'\n" +
                    "  Illusioner: '&fGerador de Illusioner'\n" +
                    "  Iron_Golem: '&fGerador de Golem de Ferro'\n" +
                    "  Lavagante: '&fGerador de Lavagante'\n" +
                    "  Llama: '&fGerador de Lhama'\n" +
                    "  Magma_Cube: '&fGerador de Cubo de Magma'\n" +
                    "  Mooshroom: '&fGerador de Coguvaca'\n" +
                    "  Mule: '&fGerador de Mula'\n" +
                    "  Ocelot: '&fGerador de Jaguatirica'\n" +
                    "  Panda: '&fGerador de Panda'\n" +
                    "  Parrot: '&fGerador de Papagaio'\n" +
                    "  Phantom: '&fGerador de Phantom'\n" +
                    "  Pig: '&fGerador de Porco'\n" +
                    "  Piglin-Zumbi: '&fGerador de Piglin-Zumbi'\n" +
                    "  Piglin: '&fGerador de Piglin'\n" +
                    "  Piglin_Brute: '&fGerador de Piglin Bárbaro'\n" +
                    "  Pillager: '&fGerador de Saqueador'\n" +
                    "  Polar_Bear: '&fGerador de Urso-Polar'\n" +
                    "  Pufferfish: '&fGerador de Baiacú'\n" +
                    "  Rabbit: '&fGerador de Coelho'\n" +
                    "  Ravager: '&fGerador de Devastador'\n" +
                    "  Salmon: '&fGerador de Salmão'\n" +
                    "  Sheep: '&fGerador de Ovelha'\n" +
                    "  Shulker: '&fGerador de Shulker'\n" +
                    "  Silverfish: '&fGerador de Traça'\n" +
                    "  Skeleton: '&fGerador de Esqueleto'\n" +
                    "  Skeleton_Horse: '&fCavalo-Esqueleto'\n" +
                    "  Slime: '&fGerador de Slime'\n" +
                    "  Snow_Golem: '&fGerador de Snowman'\n" +
                    "  Spider: '&fGerador de Aranha'\n" +
                    "  Squid: '&fGerador de Lula'\n" +
                    "  Stray: '&fGerador de Esqueleto-Errante'\n" +
                    "  Tadpole: '&fGerador de Girino'\n" +
                    "  Trader_Llama: '&fGerador de Lhama do vendedor'\n" +
                    "  Tropical_Fish: '&fGerador de Peixe-Tropical'\n" +
                    "  Turtle: '&fGerador de Tartaruga'\n" +
                    "  Vex: '&fGerador de Vex'\n" +
                    "  Villager: '&fGerador de Aldeão'\n" +
                    "  Vindicator: '&fGerador de Vingador'\n" +
                    "  Wandering_Trader: '&fGerador de Vendedor Ambulante'\n" +
                    "  Warden: '&fGerador de Defensor'\n" +
                    "  Witch: '&fGerador de Bruxa'\n" +
                    "  Wither: '&fGerador de Wither'\n" +
                    "  Wither_Skeleton: '&fGerador de Esqueleto Wither'\n" +
                    "  Wolf: '&fGerador de Lobo'\n" +
                    "  Zoglin: '&fGerador de Zoglin'\n" +
                    "  Zombie: '&fGerador de Zumbi'\n" +
                    "  Zombie_Horse: '&fGerador de Cavalo-Zumbi'\n" +
                    "  Zombie_Pigman: '&fGerador de Homem-Porco-Zumbi'\n" +
                    "  Zombie_Villager: '&fGerador de Aldeão Zumbi'\n" +
                    "\n" +
                    "# Leia com muito mais atenção\n" +
                    "# Você pode mudar o Lore dos geradores como quiser, mas se você ja tem geradores no seu inventário\n" +
                    "# ou no seu baú, que não estão colocados obviamente, trocando o lore abaixo, seus geradores não vão funcionar\n" +
                    "# pois eles tem o lore antigo, diferente desses que você mudou abaixo\n" +
                    "# Se você quiser alterar esses lores, recomendo que faça isso no início do seu servidor, enquanto ninguém tem geradores\n" +
                    "Spawner_Lore:\n" +
                    "  Allay: '&eTipo: &Allay, &eDono: &f%owner%'\n" +
                    "  Axolotl: '&eTipo: &Axolote, &eDono: &f%owner%'\n" +
                    "  Bat: '&eTipo: &aMorcego, &eDono: &f%owner%'\n" +
                    "  Bee: '&eTipo: &aAbelha, &eDono: &f%owner%'\n" +
                    "  Blaze: '&eTipo: &aBlaze, &eDono: &f%owner%'\n" +
                    "  Cat: '&eTipo: &aGato, &eDono: &f%owner%'\n" +
                    "  Cave_Spider: '&eTipo: &aAranha das cavernas, &eDono: &f%owner%'\n" +
                    "  Chicken: '&eTipo: &aGalinha, &eDono: &f%owner%'\n" +
                    "  Cod: '&eTipo: &aBacalhau, &eDono: &f%owner%'\n" +
                    "  Cow: '&eTipo: &aVaca, &eDono: &f%owner%'\n" +
                    "  Creeper: '&eTipo: &aCreeper, &eDono: &f%owner%'\n" +
                    "  Dolphin: '&eTipo: &aGolfinho, &eDono: &f%owner%'\n" +
                    "  Donkey: '&eTipo: &aBurro, &eDono: &f%owner%'\n" +
                    "  Drowned: '&eTipo: &aAfogado, &eDono: &f%owner%'\n" +
                    "  Elder_Guardian: '&eTipo: &aGuardião mestre, &eDono: &f%owner%'\n" +
                    "  Ender_Dragon: '&eTipo: &aDragão do end, &eDono: &f%owner%'\n" +
                    "  Enderman: '&eTipo: &aEnderman, &eDono: &f%owner%'\n" +
                    "  Endermite: '&eTipo: &aEndermite, &eDono: &f%owner%'\n" +
                    "  Evoker: '&eTipo: &aInvocador, &eDono: &f%owner%'\n" +
                    "  Experience_Bottle: '&eTipo: &aFrasco de experiência, &eDono: &f%owner%'\n" +
                    "  Fox: '&eTipo: &aRaposa, &eDono: &f%owner%'\n" +
                    "  Frog: '&eTipo: &Sapo, &eDono: &f%owner%'\n" +
                    "  Ghast: '&eTipo: &aGhast, &eDono: &f%owner%'\n" +
                    "  Giant: '&eTipo: &aGiant, &eDono: &f%owner%'\n" +
                    "  Glow_Squid: '&eTipo: &aLula-Brilhante, &eDono: &f%owner%'\n" +
                    "  Goat: '&eTipo: &aCabra, &eDono: &f%owner%'\n" +
                    "  Guardian: '&eTipo: &aGuardião, &eDono: &f%owner%'\n" +
                    "  Hoglin: '&eTipo: &aHoglin, &eDono: &f%owner%'\n" +
                    "  Horse: '&eTipo: &aCavalo, &eDono: &f%owner%'\n" +
                    "  Husk: '&eTipo: &aZumbi-Múmia, &eDono: &f%owner%'\n" +
                    "  Illusioner: '&eTipo: &aIllusioner, &eDono: &f%owner%'\n" +
                    "  Iron_Golem: '&eTipo: &aGolem de Ferro, &eDono: &f%owner%'\n" +
                    "  Lavagante: '&eTipo: &aLavagante, &eDono: &f%owner%'\n" +
                    "  Llama: '&eTipo: &aLhama, &eDono: &f%owner%'\n" +
                    "  Magma_Cube: '&eTipo: &aCubo de Magma, &eDono: &f%owner%'\n" +
                    "  Mooshroom: '&eTipo: &aCoguvaca, &eDono: &f%owner%'\n" +
                    "  Mule: '&eTipo: &aMula, &eDono: &f%owner%'\n" +
                    "  Ocelot: '&eTipo: &aJaguatirica, &eDono: &f%owner%'\n" +
                    "  Panda: '&eTipo: &aPanda, &eDono: &f%owner%'\n" +
                    "  Parrot: '&eTipo: &aPapagaio, &eDono: &f%owner%'\n" +
                    "  Phantom: '&eTipo: &aPhantom, &eDono: &f%owner%'\n" +
                    "  Pig: '&eTipo: &aPorco, &eDono: &f%owner%'\n" +
                    "  Piglin-Zumbi: '&eTipo: &aPiglin-Zumbi, &eDono: &f%owner%'\n" +
                    "  Piglin: '&eTipo: &aPiglin, &eDono: &f%owner%'\n" +
                    "  Piglin_Brute: '&eTipo: &aPiglin Bárbaro, &eDono: &f%owner%'\n" +
                    "  Pillager: '&eTipo: &aSaqueador, &eDono: &f%owner%'\n" +
                    "  Polar_Bear: '&eTipo: &aUrso-Polar, &eDono: &f%owner%'\n" +
                    "  Pufferfish: '&eTipo: &aBaiacú, &eDono: &f%owner%'\n" +
                    "  Rabbit: '&eTipo: &aCoelho, &eDono: &f%owner%'\n" +
                    "  Ravager: '&eTipo: &aDevastador, &eDono: &f%owner%'\n" +
                    "  Salmon: '&eTipo: &aSalmão, &eDono: &f%owner%'\n" +
                    "  Sheep: '&eTipo: &aOvelha, &eDono: &f%owner%'\n" +
                    "  Shulker: '&eTipo: &aShulker, &eDono: &f%owner%'\n" +
                    "  Silverfish: '&eTipo: &aTraça, &eDono: &f%owner%'\n" +
                    "  Skeleton: '&eTipo: &aEsqueleto, &eDono: &f%owner%'\n" +
                    "  Skeleton_Horse: '&eTipo: &aCavalo-Esqueleto, &eDono: &f%owner%'\n" +
                    "  Slime: '&eTipo: &aSlime, &eDono: &f%owner%'\n" +
                    "  Snow_Golem: '&eTipo: &aSnowman, &eDono: &f%owner%'\n" +
                    "  Spider: '&eTipo: &aAranha, &eDono: &f%owner%'\n" +
                    "  Squid: '&eTipo: &aLula, &eDono: &f%owner%'\n" +
                    "  Stray: '&eTipo: &aEsqueleto-Errante, &eDono: &f%owner%'\n" +
                    "  Tadpole: '&eTipo: &Girino, &eDono: &f%owner%'\n" +
                    "  Trader_Llama: '&eTipo: &aLhama do vendedor, &eDono: &f%owner%'\n" +
                    "  Tropical_Fish: '&eTipo: &aPeixe-Tropical, &eDono: &f%owner%'\n" +
                    "  Turtle: '&eTipo: &aTartaruga, &eDono: &f%owner%'\n" +
                    "  Vex: '&eTipo: &aVex, &eDono: &f%owner%'\n" +
                    "  Villager: '&eTipo: &aAldeão, &eDono: &f%owner%'\n" +
                    "  Vindicator: '&eTipo: &aVingador, &eDono: &f%owner%'\n" +
                    "  Wandering_Trader: '&eTipo: &aVendedor Ambulante, &eDono: &f%owner%'\n" +
                    "  Warden: '&eTipo: &Defensor, &eDono: &f%owner%'\n" +
                    "  Witch: '&eTipo: &aBruxa, &eDono: &f%owner%'\n" +
                    "  Wither: '&eTipo: &aWither, &eDono: &f%owner%'\n" +
                    "  Wither_Skeleton: '&eTipo: &aEsqueleto Wither, &eDono: &f%owner%'\n" +
                    "  Wolf: '&eTipo: &aLobo, &eDono: &f%owner%'\n" +
                    "  Zoglin: '&eTipo: &aZoglin Zumbi, &eDono: &f%owner%'\n" +
                    "  Zombie: '&eTipo: &aZumbi, &eDono: &f%owner%'\n" +
                    "  Zombie_Horse: '&eTipo: &aCavalo-Zumbi, &eDono: &f%owner%'\n" +
                    "  Zombie_Pigman: '&eTipo: &aHomem-Porco-Zumbi, &eDono: &f%owner%'\n" +
                    "  Zombie_Villager: '&eTipo: &aAldeão Zumbi, &eDono: &f%owner%'");
            writer.flush();
            writer.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    static void writePtbrMobsContent(Path mobsPtbrFile) {
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(mobsPtbrFile.toFile()), StandardCharsets.UTF_8));
            writer.write("# Mude o nome dos mobs que nascerem de um gerador não original (colocado por um jogador)\n" +
                    "Custom_Mob_Name:\n" +
                    "  Allay: '&fAllay'\n" +
                    "  Axolotl: '&fAxolote'\n" +
                    "  Bat: '&fMorcego'\n" +
                    "  Bee: '&fAbelha'\n" +
                    "  Black_Cat: '&fGato Preto'\n" +
                    "  Blaze: '&fBlaze'\n" +
                    "  Cat: '&fGato'\n" +
                    "  Cave_Spider: '&fAranha das cavernas'\n" +
                    "  Chicken: '&fGalinha'\n" +
                    "  Cod: '&fBacalhau'\n" +
                    "  Cow: '&fVaca'\n" +
                    "  Creeper: '&fCreeper'\n" +
                    "  Dolphin: '&fGolfinho'\n" +
                    "  Donkey: '&fBurro'\n" +
                    "  Drowned: '&fAfogado'\n" +
                    "  Elder_Guardian: '&fGuardião mestre'\n" +
                    "  Ender_Dragon: '&fDragão do end'\n" +
                    "  Enderman: '&fEnderman'\n" +
                    "  Endermite: '&fEndermite'\n" +
                    "  Evoker: '&fInvocador'\n" +
                    "  Experience_Bottle: '&fFrasco de experiência'\n" +
                    "  Fox: '&fRaposa'\n" +
                    "  Frog: '&fSapo'\n" +
                    "  Ghast: '&fGhast'\n" +
                    "  Giant: '&fGiant'\n" +
                    "  Glow_Squid: '&fLula-Brilhante'\n" +
                    "  Goat: '&fCabra'\n" +
                    "  Guardian: '&fGuardião'\n" +
                    "  Hoglin: '&fHoglin'\n" +
                    "  Horse: '&fCavalo'\n" +
                    "  Husk: '&fZumbi-Múmia'\n" +
                    "  Illusioner: '&fIllusioner'\n" +
                    "  Iron_Golem: '&fGolem de Ferro'\n" +
                    "  Lavagante: '&fLavagante'\n" +
                    "  Llama: '&fLhama'\n" +
                    "  Magma_Cube: '&fCubo de Magma'\n" +
                    "  Mule: '&fMula'\n" +
                    "  Mushroom_Cow: '&fCoguvaca'\n" +
                    "  Ocelot: '&fJaguatirica'\n" +
                    "  Panda: '&fPanda'\n" +
                    "  Parrot: '&fPapagaio'\n" +
                    "  Phantom: '&fPhantom'\n" +
                    "  Pig: '&fPorco'\n" +
                    "  Pig_Zombie: '&fHomem-Porco-Zumbi'\n" +
                    "  Piglin-Zumbi: '&fPiglin-Zumbi'\n" +
                    "  Piglin: '&fPiglin'\n" +
                    "  Piglin_Brute: '&fPiglin Bárbaro'\n" +
                    "  Pillager: '&fSaqueador'\n" +
                    "  Polar_Bear: '&fUrso-Polar'\n" +
                    "  Pufferfish: '&fBaiacú'\n" +
                    "  Rabbit: '&fCoelho'\n" +
                    "  Ravager: '&fDevastador'\n" +
                    "  Red_Cat: '&fGato Vermelho'\n" +
                    "  Salmon: '&fSalmão'\n" +
                    "  Sheep: '&fOvelha'\n" +
                    "  Shulker: '&fShulker'\n" +
                    "  Siamese_Cat: '&fGato Siamês'\n" +
                    "  Silverfish: '&fTraça'\n" +
                    "  Skeleton: '&fEsqueleto'\n" +
                    "  Skeleton_Horse: '&fCavalo-Esqueleto'\n" +
                    "  Slime: '&fSlime'\n" +
                    "  Snowman: '&fSnowman'\n" +
                    "  Spider: '&fAranha'\n" +
                    "  Squid: '&fLula'\n" +
                    "  Stray: '&fEsqueleto-Errante'\n" +
                    "  Tadpole: '&fGirino'\n" +
                    "  Trader_Llama: '&fLhama do vendedor'\n" +
                    "  Tropical_Fish: '&fPeixe-Tropical'\n" +
                    "  Turtle: '&fTartaruga'\n" +
                    "  Vex: '&fVex'\n" +
                    "  Villager: '&fAldeão'\n" +
                    "  Vindicator: '&fVingador'\n" +
                    "  Wandering_Trader: '&fVendedor Ambulante'\n" +
                    "  Warden: '&fDefensor'\n" +
                    "  Witch: '&fBruxa'\n" +
                    "  Wither: '&fWither'\n" +
                    "  Wither_Skeleton: '&fEsqueleto Wither'\n" +
                    "  Wolf: '&fLobo'\n" +
                    "  Zoglin: '&fZoglin'\n" +
                    "  Zombie: '&fZumbi'\n" +
                    "  Zombie_Horse: '&fCavalo-Zumbi'\n" +
                    "  Zombie_Villager: '&fAldeão Zumbi'");
            writer.flush();
            writer.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}