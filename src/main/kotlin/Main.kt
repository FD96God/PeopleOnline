fun main() {
    val sec = 60 * 60 * 24 + 1
    println(agoToText(sec))
}

fun agoToText(sec: Int): String = when (sec) {
    in 0..60 -> "был(а) только что"
    in 61..60 * 60 -> "был(а) в сети ${minHoursText(sec)} назад"
    in 60 * 60 + 1..24 * 60 * 60 -> "был(а) в сети ${minHoursText(sec)} назад"
    in 24 * 60 * 60 + 1..2 * 24 * 60 * 60 -> "был(а) в сети вчера"
    in 2 * 24 * 60 * 60 + 1..3 * 24 * 60 * 60 -> "был(а) в сети позавчера"
    else -> "был(а) в сети давно"
}

fun minHoursText(sec: Int): String {
    val min: Int = sec / 60
    val hour: Int = sec / 60 / 60
    val result: String = if (sec <= 60 * 60) {

        when (min) {
            in 5..20, in min / 10 * 10 + 5..min / 10 * 10 + 9, 30, 40, 50, 60 -> "$min минут"
            min / 10 * 10 + 1 -> "$min минуту"
            else -> "$min минуты"
        }
    } else {

        when (hour) {
            in 5..20, in hour / 10 * 10 + 5..hour / 10 * 10 + 9 -> "$hour часов"
            hour / 10 * 10 + 1 -> "$hour час"
            else -> "$hour часа"
        }
    }
    return result
}