package com.example.syncedn

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.Paint
import android.graphics.PixelFormat
import android.graphics.drawable.Drawable
import android.view.View
import androidx.core.graphics.PathParser
import androidx.core.graphics.withScale
import androidx.core.graphics.withTranslation

@Suppress("ConstPropertyName")
object UI {
    const val calendarButton = 1000
    const val chatsButton = 1001
    const val continueButton = 1002
    const val createTeamButton = 1003
    const val createTeamChoiceButton = 1004
    const val forgotPasswordButton = 1005
    const val getStartedButton = 1006
    const val googleButton = 1007
    const val homeTab = 1008
    const val joinTeamButton = 1009
    const val joinTeamChoiceButton = 1010
    const val loginButton = 1011
    const val loginEmail = 1012
    const val loginPassword = 1013
    const val loginPasswordToggle = 1014
    const val notificationsButton = 1015
    const val openRegisterButton = 1016
    const val otpCode = 1017
    const val profileButton = 1018
    const val registerButton = 1019
    const val registerConfirm = 1020
    const val registerConfirmToggle = 1021
    const val registerEmail = 1022
    const val registerName = 1023
    const val registerPassword = 1024
    const val registerPasswordToggle = 1025
    const val resetConfirm = 1026
    const val resetConfirmToggle = 1027
    const val resetEmail = 1028
    const val resetPassword = 1029
    const val resetPasswordToggle = 1030
    const val scheduleCard = 1031
    const val scheduleTab = 1032
    const val sendCodeButton = 1034
    const val settingsTab = 1035
    const val songsButton = 1036
    const val successMessage = 1037
    const val teamCode = 1038
    const val teamHubButton = 1039
    const val teamName = 1040
    const val teamsTab = 1041
    const val verifyOtpButton = 1042
    const val welcomeText = 1043
    const val worshipCard = 1044

    const val announcementsButton = 1045
    const val teamTitle = 1046
    const val pageBack = 1047
    const val settingsAvatar = 1048
    const val openProfileButton = 1049
    const val settingsTeam = 1050
    const val notificationSwitch = 1051
    const val logoutButton = 1052
    const val aboutButton = 1053
    const val helpButton = 1054
    const val profileEmail = 1055
    const val profileAvatar = 1056
    const val changePhoto = 1057
    const val profileName = 1058
    const val profileUsername = 1059
    const val profilePhone = 1060
    const val countrySpinner = 1061
    const val languageSpinner = 1062
    const val saveProfileButton = 1063
}

@Suppress("ViewConstructor")
class CornerArt(context: Context, private val flip: Boolean) : View(context) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.withScale(width / 210f, height / 210f) {
            if (flip) { translate(210f, 0f); scale(-1f, 1f) }
            paint.color = Color.rgb(80, 5, 104); drawCircle(110f, -22f, 95f, paint)
            paint.color = Color.rgb(73, 10, 53); drawCircle(18f, 24f, 104f, paint)
            paint.color = Color.rgb(158, 6, 159); drawCircle(-40f, 141f, 103f, paint)
        }
    }
}

class EyeDrawable : Drawable() {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply { color = Color.rgb(21, 22, 49); style = Paint.Style.STROKE; strokeWidth = 1.6f }
    override fun draw(canvas: Canvas) {
        canvas.withTranslation(bounds.left.toFloat(), bounds.top.toFloat()) {
            scale(bounds.width() / 24f, bounds.height() / 24f)
            val path = PathParser.createPathFromPathData("M1,12 C6,3 18,3 23,12 M7,12 A5,5 0,1 0,17 12 A5,5 0,1 0,7 12")
            drawPath(path, paint)
        }
    }
    override fun setAlpha(alpha: Int) { paint.alpha = alpha }
    override fun setColorFilter(filter: ColorFilter?) { paint.colorFilter = filter }
    @Suppress("DEPRECATION")
    @Deprecated("Deprecated in Java")
    override fun getOpacity() = PixelFormat.TRANSLUCENT
}

@Suppress("ViewConstructor")
class Symbol(context: Context, name: String, color: Int) : View(context) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply { this.color = color; style = Paint.Style.STROKE; strokeWidth = 1.6f; strokeCap = Paint.Cap.ROUND; strokeJoin = Paint.Join.ROUND }
    private val path = PathParser.createPathFromPathData(when (name) {
        "mail" -> "M3,5 L21,5 L21,19 L3,19 Z M3,6 L12,13 L21,6"
        "lock" -> "M7,10 L7,7 C7,0 17,0 17,7 L17,10 M6,10 L18,10 L18,21 L6,21 Z M12,14 L12,17"
        "calendar" -> "M3,5 L21,5 L21,22 L3,22 Z M3,10 L21,10 M7,2 L7,7 M17,2 L17,7"
        "chat" -> "M3,3 L21,3 L21,19 L8,19 L3,23 Z"
        "music" -> "M9,18 L9,5 L20,2 L20,15 M9,18 A3,3 0,1 1,3 18 A3,3 0,1 1,9 18 M20,15 A3,3 0,1 1,14 15 A3,3 0,1 1,20 15"
        "teams" -> "M9,3 A4,4 0,1 1,9 11 A4,4 0,1 1,9 3 M3,22 L3,18 C3,12 15,12 15,18 L15,22 M17,3 C23,4 23,10 18,11 M18,14 C23,14 23,18 23,22"
        "bell" -> "M4,18 L6,15 L6,9 C6,1 18,1 18,9 L18,15 L20,18 Z M10,21 L14,21"
        "arrow" -> "M9,5 L16,12 L9,19"
        "home" -> "M2,11 L12,2 L22,11 M5,9 L5,22 L10,22 L10,15 L14,15 L14,22 L19,22 L19,9"
        "settings" -> "M2,12 A10,10 0,1 1,22 12 A10,10 0,1 1,2 12 M6,8 L18,8 M6,12 L18,12 M6,16 L18,16"
        else -> "M4,12 A8,8 0,1 1,20 12 M20,12 L20,7 M20,12 L15,12 M4,16 L5,18 M7,20 L9,21 M12,21 L14,21 M17,20 L19,18"
    })
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.withScale(width / 24f, height / 24f) {
            drawPath(path, paint)
        }
    }
}

object Art {
    fun data(name: String): String = when (name) {
        "google_mark" -> listOf(
            "iVBORw0KGgoAAAANSUhEUgAAAB0AAAAfCAYAAAAbW8YEAAAD20lEQVR4nOWW22tcVRSHv30uycwkc8kkM5kkNIaWEJuL1jQSCy1RBA2Fpmjpi6Dgmy/qoy9e/gBBfCsoNgEVBGsRWiEoIhHFVBQLIZqQ1iC5TC7j3JK5nTnnbB9qJ07mdGZisT50Pa61zv7WWvvHWVssLi5K7rEp9xp4f0G1WgnCMnCt/4p7eRbXH/MoyTQYNugKdtBH7oFj5HuOk+8cQKr63UGFmadxY4HAzEd4f/kakcqCg+SaxZfYQS87I0+THHuBQrivJlQ4qldKWmYv0vrZBZTkTl3VA1jhNmLnXiU1fB6EuGNe5Z1KSfuVNwlNvX0gIIC6FcP33WX09ErVvIrxtly7iP/qp2DvG4AA2+/F9IWxGn0oRgY9uY6S3i2N3eg9wtb51yn6u+uHNm79RuulCxVAu8VP6olnSA9PUAweQmpu1EIKLb6Gd24a/1eXMENtRF98h0L4warAMqiQRQJ/foKi7JYlWJEAq69MUQj1gdi7DdPdhtnVRr5ziN3+J7F8YYxA9Q5vW+kU3VymqfV7eEmHhxRQbnW4+vIkhfDRMmCZCYVc90jdwLJO3cU5VHsbPAImNOiBROD5usZ1UCtBG81FxG1FuATmaJh0yxnHDqeXLKaX7JqHq1iMdSeZGIw4Q3UzWhYwtXYsLeR42MaO5Hq0NhQEzbrOxGC5V9kL58sCUujYiquOg6tgz50q3j3MIn3eJ9q9tTfHwkac6d+ayn3m4ip2mJ13m6uS1p3C4y4i0A0D1zG3A3e45X/3MInXf9/3f3j3m0US3/s7Xfp/p3i4ip2mx13EreX/3D3+m9C8O3P6s28eU2dE/fvdO5/9sIn3ed6z2P4xI/6d50f8/wX4C8A9m2Y0qD5p1QAAAABJRU5ErkJggg=="
        ).joinToString("")

        "profile_photo" -> listOf(
            "iVBORw0KGgoAAAANSUhEUgAAADUAAAA1CAYAAADh5qNwAAAUFUlEQVR4nJWaeZBlVX3HP+fc7b3X/bpfr9Mz3T0bA4wMUURk0xKROEFUEFERjYnG/GMSk5hEk0q0UpWkKpXFymrMYllYgGjFiESMCligEUIUHHAyM8Aw0yyzMEtPv+5+213O+eWPu73X3WY5Vbfuve+ce87v+1vP73eeqlYvF6FsSoFIfhdA9fWp7DeKQdWhYfZcfiWX//Sb2XrBbodq9XKi/0PrtlscPbCfHz38EPu+/z3iMFw3Jp9J+t6LZwViBaU1IoICVKV6uQwQ20e8yr6SAdhp//Bog2ve8U6uvfld+EGQLtWHQ615stYAoLWDICRxjOO4aK0AhSC0lps88o2v8/C9X6XVbP6PgPppLn7Lx1SrV0g/dEFQBZfTjuJjpfCCgOtueQ/XvOMWavU6Kp+qwFSCO/vySQ796FFOLhyi214mqI5SGaqzeu4kNokIqsNMbtnJzotfzdyOC/GDCgCd1irfuusOHv3mffS6XUBQqAHpFE3W0gyqUr1CclVTGccGWJ6BQYTN23fws7/128ztOn8dANX33Ot0eOT+r/Lj73+DqH0WRwmO4yPKwSY9HAyO4+D6AV4wRFAbY3rbHq5+222MjE0WhB5fOMpdn/4Tjj13eABEflOqBJVRkAKs1q4UESlVTvWJjdx0FK9/24286yO/gtK6UMtCPfqfUdz/xb/gsYfuxYSruBpcR2eMAddR+J5LJfCoVioImsRqlD/MxPxPccOHPo7jeqUUxPL12z/PA1/+YqFkJZ2ZMAY0DTS5hAbdBSKAKBzH5ZaP/DLv/qWPbgBIgUo5lD8TLbJ0bB82aiE2RmyCWIMSi6MFz9VUAo+x0Trzs9NMTYwQeAriNs0TT3Ny4dlBlVaaGz/0Yd7+wQ9nNA2qXs54yehSSqFRpcql0koH5zp866/+Om94+82lIucglCq1r3hWSPsEvc4qjra4DmgNKAFF6hSUwoqQJIYoihEraCWAwcQdjj+3v5irVGnF3ve+j/f/xifQrpP+XqhdriOqEI6bCkgVIszmQATe/sFf4Mq91w8QP6hofcCyh3DlJGHYw3UV2LxHSJIYxwkQa4njhFani+s6aK0x1oIIYhMWTy6UNABKFKJSpl/5M9cThl2+8pm/LRkr3318SgG/v134l4E4sK/A8H/A000ATh849A="
        ).joinToString("")

        "welcome_artwork" -> listOf(
            "iVBORw0KGgoAAAANSUhEUgAAAWgAAAJOCAYAAACa+J1jAAEAAElEQVR4nHT9yc5tW5YoNh32j7v9GRFZMZPZTJISi1EkRaqArYqGLQpumDAiCIYBwXDHb+COH8B+Cz+AXkAN99SyDbgpCbBVwKmClGlVhkqKUpLJpCozI+7Zcb4xvGKsfUN/xD3n/HumNYtRfKOYY85Z9c//n7rqAAV0ACqgCuht1L3oviA0+jaARqEAAOgGbgPdaPS8WEGd+QwodF8AQFWjqtCX7/L95nfdjQKmHWgAF0Che3pF61nMdzV9dWPGNA1MK+6HH/ZFFd+/d9qfWc273X6+69leV/n3BnCq0H7+8CGgu4Da89CA9lhWqGr/4x3Cg/3PBB+vCh6FGnqCdOoCcOGnSLu8PHPcNK7SOwc4ZZYWMv+Zp+aX6ZTmf/iM6QHgHKBeqDrz8btRfTF9P4fFsVLPnC8BTTr3yRhPAngXp+qiS+F4A3lhUKBvfA4KDTvvfPChC3XvAee3qF3A44fSgEUB3XfR3hLAnXCB0e3o+mHogU5vAInT9130zXy16e25/L2Gv35G90IqO4JCh3Sg0KfeT5c1Gf1/8sC81YpXQ83eEwqH89y6P4W83YmEwn0a8T5LdON9M6jR8pW2A145fC12U/iC9C7UeWw04uW4G7SUn0/fN+P7f/L8KBy02u25P+5jH/iS8XfUv4P3dbrd32e9/i6xT5a3tB/e3f/o8U1e9O9l9fX035v1j6o3w90X4U9Kvvp+uN7Xv3e6fQ54/U2yU8K5Nf22fP6t8fK51Nf9E/XpQd52c/2L90P89o3qN3v3237955S9t//X6T3177f1I//o0P48s/5G+d3p/TfrfX8e5/9499C/U43fN8m35e84pQ4e29/08c3I9R+/Rfe3/fJ91/sT9e3T7z2M9a/A4ffn844LwS+O4y047z/v7z45nOaX1+ffk+fl88/L/v0/fn78vPy43/93y/e3l49//3/8/X//8fL1x8vf//sf/v7L5eX9/fXv//uPyx/+4ff33//3f7z84edfn6/X//9/X//0f/f+/v39f37+fH///+z/+/f///77/u/f7+/v/89v//3/+/f/3////v7//v/3/v3//v//+//7/v3//f///3///v7+_____f//9f/++///+/7+/v//v3//f/9////33//+/f//v////+//v7//v/33v/3/v7////3f//9/v9/9////33/+//f/v3//v3/+/7//v/+///7//v////3//+3//3////+///f/+/f3/v/+//3//f///v//+v3//f/9/v//+/7+/f/7//v/+v3//f//v/+v3/v////9//3////+/7+/f/////+339//f3/9f////+v3/+/7+/f//9//v3//v////f/+f3//f///v//33/+f//9v3/+v3//f////f/9v////9v//+///v/+v3/+v7+/f//9//v3//v/+//f/+/f3/v3/v3/+///v//+///v3//f//f/9v///v///v3//f///v3/9v//33/+v7+/v////3/+///f/9//3/+//v/+v3//f///f3/9v3/+//v/+v134i4yK2JpInHhQzNfE5E2NfI73318SgG/v134l4E4sK/A8H/A000ATh849A="
        ).joinToString("")

        else -> error("Unknown embedded asset: $name")
    }
}
