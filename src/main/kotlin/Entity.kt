import kotlin.random.Random

abstract class Entity {
    constructor(attack: Int, defend: Int, health: Int)  {
        this.attack = attack
        this.defend = defend
        this.health = health
        this.maxHealth = health
    }
    var maxHealth: Int = 0

    var attack: Int = MIN_ATTACK
        set(value) {
            field = if (value <= MAX_ATTACK) value else MAX_ATTACK
        }

    var defend: Int = MIN_DEFEND
        set(value) {
            field = if (value <= MAX_DEFEND) value else MAX_DEFEND
        }

    var health: Int = 0
        set(value) {
            field = if (value >= MIN_HEALTH) { value } else { MIN_HEALTH }
        }

    fun dragonAttack() : Int{
        return Random.nextInt(1, attack).run {
            println("Дракон нанес $this урона")
            this
        }
    }
    fun myAttack(): Int {
        return Random.nextInt(1, attack).run {
            println("Вы нанесли $this урона")
            this
        }
    }

    fun dragonStates() {
        println("Характеристики дракона:\nЗдоровье: $health\nУдар: $MIN_ATTACK-$attack\nЗащита: $defend"
        )
    }

    fun dragonHealth() {
        if (health == MIN_HEALTH) println("Дракон погиб :)")
        println("У дракона осталось $health/$maxHealth")
    }

    fun myStates() {
        println(
            "Ваши характеристики: \nЗдоровье: $health \nУдар: $MIN_ATTACK-$attack\nЗащита: $defend"
        )
    }

    fun myHealth() {
        if (health == MIN_HEALTH) println("Вы погибли :(")
        println("У вас осталось $health/$maxHealth")
    }

    fun healka() {
        var healka = 3
        if (healka > 0) {
            if (health + maxHealth / 2 > maxHealth) this.health = maxHealth
            else this.health = health + maxHealth / 2
            healka--
            if (healka != 0) {
                println("Вы использовали хилку \nОсталось $healka")
            } else println("Не осталось хилок ")
        } else println("хилок не осталось")
    }

    fun attackAlgoritm(attack: Int, protection: Int): Boolean {
        val attackModifier = (attack - protection + 1).let {
            if (it >= 0) it else 1
        }

        return MutableList(attackModifier) {
            Random.nextInt(1, 6)
        }.any {
            it == 5 || it == 6
        }
    }
}