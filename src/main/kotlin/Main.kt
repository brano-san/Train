import kotlin.math.abs
import kotlin.random.Random


class Train{
    private val cities = listOf(
        "Москва", "Санкт-Петербург", "Новосибирск", "Екатеринбург", "Нижний Новгород",
        "Казань", "Челябинск", "Омск", "Самара", "Ростов-на-Дону",
        "Уфа", "Красноярск", "Пермь", "Воронеж", "Волгоград")

    private var begin = ""
    private var end = ""

    private var ticketCount = 0

    private var vanVolumes = mutableListOf<Int>()

    fun step1(){
        println("Шаг 1: (Выбор направления)")
        begin = cities[Random.nextInt(0, 15)]
        end = begin
        while (begin == end)
            end = cities[Random.nextInt(0, 15)]
        println("Начальный город: $begin")
        println("Конечный город: $end\n")
    }

    fun step2(){
        println("Шаг 2: (Продажа билетов)")
        ticketCount = Random.nextInt(5, 201)
        println("Было куплено $ticketCount билетов\n")
    }

    fun step3(){
        println("Шаг 3: (Формирование поезда)")
        var sum = 0
        while (sum < ticketCount){
            vanVolumes.add(Random.nextInt(5, 26))
            println("Вместимость вагона ${vanVolumes.count()}: ${vanVolumes.last()}")
            sum += vanVolumes.last()
        }

        println("Количество вагонов: ${vanVolumes.count()}\n")
    }

    fun step4(){
        println("Поезд $begin - $end, состоящий из ${vanVolumes.count()} вагонов был отправлен")
        for (i in vanVolumes.indices){
            println("Вместимость вагона ${i + 1}: ${vanVolumes[i]}")
            ticketCount -= vanVolumes[i]
        }
        println("В последнем вагоне ${vanVolumes.last() - abs(ticketCount)} человек\n")
    }
}


fun main(args: Array<String>) {
    do{
        val train = Train()
        train.step1()
        train.step2()
        train.step3()
        train.step4()
        println("Для выхода напишите 'EXIT':")
    } while (readln() != "EXIT")
}