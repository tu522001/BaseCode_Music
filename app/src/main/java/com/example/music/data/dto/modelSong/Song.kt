package com.example.music.data.dto.modelSong

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

/**
 * Created by Truong on 29/10/2022.
 */
@JsonClass(generateAdapter = true)
@Parcelize
data class Song(
    val album_id: String,
    val album_image: String,
    val album_name: String,
    val artist_id: String,
    val artist_idstr: String,
    val artist_name: String,
    val audio: String,
    val audiodownload: String,
    val audiodownload_allowed: Boolean,
    val duration: String,
    val id: String,
    val image: String,
    val license_ccurl: String,
    val name: String,
    val releasedate: String,
    val thumbnail: String
) : Parcelable


//data class Song(
//    var id: Long,
//    var thumbnail: String,
//    var album_id: String,
//    var position: Int,
//    var name: String,
//    var duration: Int,
//    var license_ccurl: String,
//    var audio: String,
//    var audiodownload: String,
//    var audiodownload_allowed: Boolean
//) {
//
//
//    companion object {
//        fun dataSongFake(): MutableList<Song> {
//            return mutableListOf(
//                Song(
//                    1827387L,
//                    "https://xemanhdep.com/wp-content/uploads/2016/04/anh-dep-hinh-nen-04.jpg",
//                    "12431234",
//                    1,
//                    "Opening (Champagner Thema)",
//                    101,
//                    "http://creativecommons.org/licenses/by-nc-nd/3.0/",
//                    "https://prod-1.storage.jamendo.com/?trackid=1827387&format=mp31&from=MuIMKK54E%2BTrri%2Fm%2B1%2BMIg%3D%3D%7C28g6dm9dpFMABLGxhW69Xw%3D%3D",
//                    "https://prod-1.storage.jamendo.com/download/track/1827387/mp32/",
//                    true
//                ),
//                Song(
//                    1827389L,
//                    "https://th.bing.com/th?id=ORMS.77780aeb88f6c7858a2f0ab04415c1b0&pid=Wdp&w=612&h=304&qlt=90&c=1&rs=1&dpr=1.5&p=0",
//                    "12431234",
//                    3,
//                    "Perlender Champagner",
//                    115,
//                    "http://creativecommons.org/licenses/by-nc-nd/3.0/",
//                    "https://prod-1.storage.jamendo.com/?trackid=1827389&format=mp31&from=SLdrOX0x4W6j0IHW0YhOIQ%3D%3D%7CYjBlcDKo%2BVr4RxPsh7v8Kw%3D%3D",
//                    "https://prod-1.storage.jamendo.com/download/track/1827389/mp32/",
//                    true
//                ),
//                Song(
//                    1827390L,
//                    "https://th.bing.com/th?id=ORMS.77780aeb88f6c7858a2f0ab04415c1b0&pid=Wdp&w=612&h=304&qlt=90&c=1&rs=1&dpr=1.5&p=0",
//                    "12431234",
//                    8, "Die ganze Kunst des Genießens",
//                    236,
//                    "http://creativecommons.org/licenses/by-nc-nd/3.0/",
//                    "https://prod-1.storage.jamendo.com/?trackid=1827390&format=mp31&from=Pb3erCMUmcKmB%2BSegWItqw%3D%3D%7CBOsNAEZEscZsPwmmSO6sZg%3D%3D",
//                    "https://prod-1.storage.jamendo.com/download/track/1827390/mp32/",
//                    true
//                ),
//                Song(
//                    1827391L,
//                    "https://th.bing.com/th?id=ORMS.77780aeb88f6c7858a2f0ab04415c1b0&pid=Wdp&w=612&h=304&qlt=90&c=1&rs=1&dpr=1.5&p=0",
//                    "12431234",
//                    12,
//                    "What´s left is love",
//                    397,
//                    "http://creativecommons.org/licenses/by-nc-nd/3.0/",
//                    "https://prod-1.storage.jamendo.com/?trackid=1827391&format=mp31&from=k71ACGOpC%2BZA59kf9%2F%2BQxQ%3D%3D%7Cj3TP83ZOKpZCpPDf9sAkhA%3D%3D",
//                    "https://prod-1.storage.jamendo.com/download/track/1827391/mp32/",
//                    true
//                ),
//                Song(
//                    1827392L,
//                    "https://th.bing.com/th?id=ORMS.77780aeb88f6c7858a2f0ab04415c1b0&pid=Wdp&w=612&h=304&qlt=90&c=1&rs=1&dpr=1.5&p=0",
//                    "12431234",
//                    5,
//                    "Erster Frühlingsduft",
//                    176,
//                    "http://creativecommons.org/licenses/by-nc-nd/3.0/",
//                    "https://prod-1.storage.jamendo.com/?trackid=1827392&format=mp31&from=UiNsqdVHsDH77%2BLJZty0pQ%3D%3D%7Cr4Cf7td3jU8YFifsDSR3NQ%3D%3D",
//                    "https://prod-1.storage.jamendo.com/download/track/1827392/mp32/",
//                    true
//                ),
//                Song(
//                    1827393L,
//                    "https://th.bing.com/th?id=ORMS.77780aeb88f6c7858a2f0ab04415c1b0&pid=Wdp&w=612&h=304&qlt=90&c=1&rs=1&dpr=1.5&p=0",
//                    "12431234",
//                    6,
//                    "Wundersames Versteckspiel",
//                    125,
//                    "http://creativecommons.org/licenses/by-nc-nd/3.0/",
//                    "https://prod-1.storage.jamendo.com/?trackid=1827393&format=mp31&from=w3pmxA7dmJLDgnNs8u5S2A%3D%3D%7Cxr8RIA%2FKqLIbBJKhe6toPw%3D%3D",
//                    "https://prod-1.storage.jamendo.com/download/track/1827393/mp32/",
//                    true
//                ),
//                Song(
//                    1827394L,
//                    "https://th.bing.com/th?id=ORMS.77780aeb88f6c7858a2f0ab04415c1b0&pid=Wdp&w=612&h=304&qlt=90&c=1&rs=1&dpr=1.5&p=0",
//                    "12431234",
//                    2,
//                    "Sonntag Nachmittag",
//                    250,
//                    "http://creativecommons.org/licenses/by-nc-nd/3.0/",
//                    "https://prod-1.storage.jamendo.com/?trackid=1827394&format=mp31&from=F7RWPdLRDtaH%2F0wPYE9Jrw%3D%3D%7CShgCGAruIzOztYcygAz4Sw%3D%3D",
//                    "https://prod-1.storage.jamendo.com/download/track/1827394/mp32/",
//                    true
//                ),
//                Song(
//                    1827395L,
//                    "https://th.bing.com/th?id=ORMS.77780aeb88f6c7858a2f0ab04415c1b0&pid=Wdp&w=612&h=304&qlt=90&c=1&rs=1&dpr=1.5&p=0",
//                    "12431234",
//                    9,
//                    "Eine Entscheidung",
//                    121,
//                    "http://creativecommons.org/licenses/by-nc-nd/3.0/",
//                    "https://prod-1.storage.jamendo.com/?trackid=1827395&format=mp31&from=02MAnZ5kX2ZjH83B78ZrHg%3D%3D%7C5DJVGbHalxgkKl0Urb1EMg%3D%3D",
//                    "https://prod-1.storage.jamendo.com/download/track/1827395/mp32/",
//                    true
//                ),
//                Song(
//                    1827396L,
//                    "https://th.bing.com/th?id=ORMS.77780aeb88f6c7858a2f0ab04415c1b0&pid=Wdp&w=612&h=304&qlt=90&c=1&rs=1&dpr=1.5&p=0",
//                    "12431234",
//                    7,
//                    "Gabriel Faure´s Pavane, op. 50 - Gabriel Faure; (1845-1924)",
//                    265,
//                    "http://creativecommons.org/licenses/by-nc-nd/3.0/",
//                    "https://prod-1.storage.jamendo.com/?trackid=1827396&format=mp31&from=WmbSoaPJI%2BVRp%2FbeyOZP0A%3D%3D%7COVLgysKjYLlKg9kr2qTBYw%3D%3D",
//                    "https://prod-1.storage.jamendo.com/download/track/1827396/mp32/",
//                    true
//                ),
//                Song(
//                    827397L,
//                    "https://th.bing.com/th?id=ORMS.77780aeb88f6c7858a2f0ab04415c1b0&pid=Wdp&w=612&h=304&qlt=90&c=1&rs=1&dpr=1.5&p=0",
//                    "12431234",
//                    11,
//                    "Touched By An Angel",
//                    244,
//                    "http://creativecommons.org/licenses/by-nc-nd/3.0/",
//                    "https://prod-1.storage.jamendo.com/?trackid=1827397&format=mp31&from=pfuMNizhJP4SHwxx%2BW%2FdKg%3D%3D%7CPjYjNuSB1EFVah6%2F18b5nA%3D%3D",
//                    "https://prod-1.storage.jamendo.com/download/track/1827397/mp32/",
//                    true
//                ),
//                Song(
//                    1827398L,
//                    "https://th.bing.com/th?id=ORMS.77780aeb88f6c7858a2f0ab04415c1b0&pid=Wdp&w=612&h=304&qlt=90&c=1&rs=1&dpr=1.5&p=0",
//                    "12431234",
//                    4,
//                    "Bunessan (Morning Has Broken)",
//                    213,
//                    "http://creativecommons.org/licenses/by-nc-nd/3.0/",
//                    "https://prod-1.storage.jamendo.com/?trackid=1827398&format=mp31&from=izM09b%2B%2BHt9oydfdLfB%2BZw%3D%3D%7CweRWV1bhO9xaUHUGh%2Fw%2F3Q%3D%3D",
//                    "https://prod-1.storage.jamendo.com/download/track/1827398/mp32/",
//                    true
//                )
//            )
//        }
//    }
//}