package pokemonProject.pokedex;

import java.util.Arrays;
    public class Pokemon {
        public String pokemonName;
        public int currentHp, maxHp, attack, defense;
        public String[] specialAttackName;
        public int speed;

        public void main(String[] args) {
        }

        public Pokemon (String pokemonName, int maxHp, int attack, int defense, String[] specialAttackName, int speed) {
            this.pokemonName = pokemonName;
            this.maxHp = maxHp;
            this.attack = attack;
            this.defense = defense;
            this.specialAttackName = specialAttackName;
            this.speed = speed;
            this.currentHp = maxHp;
        }

        public String stats() {
            return "| Макс_ОЗ: " + maxHp + "| ОЗ: " + currentHp + ", АТК: " + attack +
                    ", ОБР: " + defense + " СКР: " + speed + ", Спец_АТК: " + Arrays.toString(specialAttackName) + " |\n";
        }

        public void sleep() {
            if (currentHp < maxHp / 2) {
                System.out.println(pokemonName + " передохнул.");
                currentHp += maxHp / 2;
                if (currentHp > maxHp) {
                    currentHp = maxHp;
                }
            } else {
                System.out.println(pokemonName + " не может передохнуть.");
            }
        }

        public void basicAttack() {
            System.out.println(pokemonName + " использует Атаку!");
        }

//        public void takingDamageFromItself() {
//            int damage = attack - defense;
//            System.out.println(pokemonName + " случайно попадает по себе и наносит " + damage + "урона");
//            currentHp -= damage;
//        }

        public void defensiveStance() {
            int defensiveStanceBonus = defense / 2;
            System.out.println(pokemonName + " встаёт в оборонительную стойку и повышает свою защиту на " + defensiveStanceBonus + "очков");
            defense += defensiveStanceBonus;
        }

        public void kO() {
            if (currentHp <= 0) {
                System.out.println(pokemonName + " потерял сознание и не может продолжать сражение");
            }
        }

        public void overgrow() {
            if (currentHp < maxHp / 2) {
                attack += attack / 2;
                System.out.println(pokemonName + " использует Overgrow, повышая свою АТК и ОБР!");
            } else {
                System.out.println("Вы не соблюли условия" + Arrays.toString(specialAttackName) + ", ничего не происходит, Вы теряете свой ход.");
            }

        }

        public void swarm() {
            int damage = maxHp / 2;
            currentHp -= damage;
            attack += attack / 2;
            defense += defense / 2;
            System.out.println("Ваш " + pokemonName + " получил " + damage + " урона, но его АТК и ОБР повысились!");
        }

        public void innerFocus() {
            int heal = attack / 2;
            currentHp += heal;
            if (currentHp > maxHp) {
                currentHp = maxHp;
            }
            defense += attack / 2;
            System.out.println("Ваш " + pokemonName + " восстановил " + heal + " ОЗ и повысил свою ОБР!");
        }

        public void skipTurn() {
            System.out.println(pokemonName + " пропускает ход.");
        }

    }
