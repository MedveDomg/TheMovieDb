package omg.medvedomg.labracodetestapp.other

import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter

/**
 * Created by medvedomg on 04.07.17.
 */
class DateParserUtil {
    companion object {
        fun parseDate(dateStr: String?): String {
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            val dateTime = LocalDate.parse(dateStr, formatter);

            return dateTime.year.toString()
        }
    }
}