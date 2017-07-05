package omg.medvedomg.labracodetestapp.other

import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter

/**
 * Created by medvedomg on 04.07.17.
 */
class DateParserUtil {

    //parser date from format 2017-05-30 to 2017
    companion object {

        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        fun parseDate(dateStr: String?): String {

            val dateTime = LocalDate.parse(dateStr, formatter);

            return dateTime.year.toString()
        }
    }
}