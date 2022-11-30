import model.Dragon
import model.Hero
import kotlin.random.Random

fun main() {
    println(
        "\n\n\nПривет, Странник. У меня для тебя миссия 'Спасти принцессу'" +
                "\nНо не все так просто. Замок охраняет Дракон"
    )
    var health = 1
    do {
        try {
            println("Чтобы победить его, выбери себе достойное обмундирование " +
                    "и скажи сколько здоровья оно дает(напиши количество жизней)"
            )
            health = readln().toInt()
        } catch (e: Exception) {
            println("введить правильное значение")
        }
    } while (health == 0)
    val hero = Hero(randomTwenty(), randomTwenty(), health)
    val dragon = Dragon(randomTwenty(), randomTwenty(), hero.health * 2)

    println("Вы дошли до замка. В далеке виднеется дракон.")
    println("Он вас заметил и прилетел на защиту принцессы. Битва неизбежна.")

    while (hero.health > 0 && dragon.health > 0) {
        println(
            "\nВыберите действие: " +
                    "\n(1)замахнуться на дракона" +
                    "\n(2)использовать хилку" +
                    "\n(3)моё состояние" +
                    "\n(4)состояние дракона" +
                    "\n(0)выключить"
        )
        print(">")
        when (readln()) {
            "0" -> break
            "1" -> {
                if (hero.attackAlgoritm(hero.attack, dragon.defend)) {
                    dragon.health -= hero.myAttack()
                    dragon.dragonHealth()
                } else println("Вы не попали")
                println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-")
                if (dragon.attackAlgoritm(dragon.attack, hero.defend) && dragon.health != 0) {
                    hero.health -= dragon.dragonAttack()
                    hero.myHealth()
                } else println("Дракон не попал")
            }
            "2" -> hero.healka()
            "3" -> hero.myStates()
            "4" -> dragon.dragonStates()
            else -> println("Кажется вы перепутали -_-")
        }
    }
    if (dragon.health == 0) println("Вы победили")
    if (hero.health == 0) println("GAME OVER")
}

fun randomTwenty(): Int {
    return Random.nextInt(1, 20)
}