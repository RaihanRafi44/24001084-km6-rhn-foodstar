package com.raihan.foodstar.data.datasource.menu

import com.raihan.foodstar.data.model.Menu

class DummyMenuDataSource : MenuDataSource {
    override fun getMenus(): List<Menu> {
        return listOf(
            Menu(
                name = "Nasi Goreng Spesial",
                imgUrl = "https://raw.githubusercontent.com/RaihanRafi44/foodstar-assets/main/menu_img/img_fried_rice.webp",
                price = 40000.0,
                desc = "Nasi goreng spesial merupakan hidangan nasi goreng yang disajikan dengan sentuhan khusus dan beragam bahan tambahan yang memperkaya cita rasanya. Nasi putih yang dimasak sempurna kemudian dicampur dengan berbagai bahan seperti potongan daging ayam, sapi, atau udang, serta telur yang dikocok dan dicampur bersama nasi.\n" +
                        "\n" +
                        "Selain itu, nasi goreng spesial juga diperkaya dengan tambahan sayuran seperti wortel, kubis, buncis, dan daun bawang yang memberikan warna, tekstur, dan nutrisi yang seimbang pada hidangan ini. Bumbu-bumbu rempah seperti bawang putih, bawang merah, cabai, kecap manis, serta sedikit garam dan merica, memberikan cita rasa yang khas dan menggugah selera.\n" +
                        "\n" +
                        "Tak lupa, beberapa versi nasi goreng spesial juga ditambahkan dengan bahan tambahan seperti kerupuk, irisan tomat, mentimun, atau acar untuk memberikan sentuhan segar dan tekstur yang kontras.\n" +
                        "\n" +
                        "Nasi goreng spesial bukan hanya sekadar hidangan lezat, tetapi juga menjadi simbol dari kekayaan rasa dan variasi bahan makanan Indonesia. Dengan kombinasi yang sempurna antara nasi yang gurih, bumbu rempah yang kaya, dan beragam bahan tambahan, nasi goreng spesial adalah sajian yang menggugah selera dan memanjakan lidah bagi siapa pun yang menikmatinya.",
                address = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345",
                addressUrl = "https://www.google.com/maps/place/The+Breeze+BSD+City,+Jl.+BSD+Green+Office+Park+Jl.+BSD+Grand+Boulevard,+Sampora,+BSD,+Kabupaten+Tangerang,+Banten+15345/data=!4m2!3m1!1s0x2e69fb03fd576c99:0xf5e7f5736ced52fa?utm_source=mstt_1&entry=gps&lucs=47068615&g_ep=CAESCTExLjk0LjMwNBgAIIgnKgg0NzA2ODYxNUICSUQ%3D"
            ),
            Menu(
                name = "Nasi Goreng Hitam",
                imgUrl = "https://raw.githubusercontent.com/RaihanRafi44/foodstar-assets/main/menu_img/img_fried_rice_black_pepper.jpg",
                price = 30000.0,
                desc = "Nasi Goreng Lada Hitam adalah varian yang menggoda dari hidangan nasi goreng yang diberi sentuhan unik dengan kehadiran lada hitam yang memberikan cita rasa yang tajam dan aroma yang menggugah selera. Berikut adalah deskripsi lengkapnya:\n" +
                        "\n" +
                        "Nasi Goreng Lada Hitam adalah sajian yang memikat dengan kombinasi nasi yang gurih dan kaya dengan rempah lada hitam yang khas. Nasi putih yang dimasak sempurna kemudian dicampur dengan berbagai bahan tambahan seperti potongan daging ayam, sapi, atau udang, serta telur yang dikocok dan dicampur bersama nasi.\n" +
                        "\n" +
                        "Yang membuat Nasi Goreng Lada Hitam istimewa adalah penggunaan lada hitam yang segar dan aromatik. Lada hitam ditambahkan dalam jumlah yang cukup untuk memberikan cita rasa pedas yang khas dan aroma yang menyengat. Selain lada hitam, bumbu-bumbu rempah seperti bawang putih, bawang merah, cabai, serta sedikit garam dan merica juga ditambahkan untuk memberikan cita rasa yang mendalam.\n" +
                        "\n" +
                        "Tak lupa, beberapa versi Nasi Goreng Lada Hitam juga mungkin ditambahkan dengan potongan sayuran seperti wortel, kubis, buncis, dan daun bawang untuk memberikan tekstur yang beragam dan nutrisi yang seimbang. Beberapa varian mungkin juga menambahkan irisan tomat, mentimun, atau acar sebagai pelengkap.\n" +
                        "\n" +
                        "Nasi Goreng Lada Hitam adalah hidangan yang tidak hanya menggugah selera tetapi juga memberikan pengalaman rasa yang unik dan memuaskan. Dengan kombinasi yang sempurna antara rasa gurih, pedas, dan aromatik, hidangan ini cocok untuk pencinta rempah dan pecinta cita rasa yang kuat.",
                address = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345",
                addressUrl = "https://www.google.com/maps/place/The+Breeze+BSD+City,+Jl.+BSD+Green+Office+Park+Jl.+BSD+Grand+Boulevard,+Sampora,+BSD,+Kabupaten+Tangerang,+Banten+15345/data=!4m2!3m1!1s0x2e69fb03fd576c99:0xf5e7f5736ced52fa?utm_source=mstt_1&entry=gps&lucs=47068615&g_ep=CAESCTExLjk0LjMwNBgAIIgnKgg0NzA2ODYxNUICSUQ%3D"
            ),
            Menu(
                name = "Mie Goreng Aceh",
                imgUrl = "https://raw.githubusercontent.com/RaihanRafi44/foodstar-assets/main/menu_img/img_noodle_aceh.jpg",
                price = 20000.0,
                desc = "Mie Goreng Aceh adalah hidangan mie goreng yang berasal dari Aceh, provinsi di ujung barat pulau Sumatra, Indonesia. Dikenal karena cita rasanya yang kaya dan bumbu yang kuat, Mie Goreng Aceh merupakan sajian yang menggugah selera dan seringkali dihargai karena kompleksitas rasa dan keunikan rempahnya. Berikut adalah deskripsi lengkapnya:\n" +
                        "\n" +
                        "Mie Goreng Aceh adalah hidangan mie yang disajikan dengan sentuhan khas dari Aceh, yang dikenal dengan kekayaan rempah-rempahnya. Mie kuning yang digunakan dalam hidangan ini biasanya merupakan mie telur yang tebal dan kokoh. Mie tersebut kemudian dimasak dengan berbagai bahan tambahan yang menciptakan cita rasa yang unik dan mendalam.\n" +
                        "\n" +
                        "Salah satu ciri khas Mie Goreng Aceh adalah kehadiran rempah-rempah yang melimpah. Bumbu-bumbu seperti bawang putih, bawang merah, cabai merah, jahe, lengkuas, dan daun jeruk sering digunakan untuk memberikan rasa yang kaya dan kompleks. Selain itu, rempah khas Aceh seperti bubuk ketumbar, jintan, dan kencur juga sering ditambahkan untuk meningkatkan aroma dan cita rasa.\n" +
                        "\n" +
                        "Daging sapi, ayam, atau udang sering menjadi tambahan utama dalam Mie Goreng Aceh, memberikan protein yang melengkapi hidangan ini. Sayuran seperti kubis, wortel, dan daun bawang juga sering ditambahkan untuk memberikan tekstur dan keseimbangan nutrisi.\n" +
                        "\n" +
                        "Mie Goreng Aceh biasanya disajikan dengan irisan telur dadar yang lembut dan empuk di atasnya, serta taburan bawang goreng sebagai garnis. Beberapa versi mungkin juga disajikan dengan irisan tomat segar atau mentimun sebagai pelengkap.\n" +
                        "\n" +
                        "Hidangan ini tidak hanya menyajikan cita rasa yang kaya dan lezat, tetapi juga memberikan pengalaman kuliner yang memikat bagi siapa pun yang menikmatinya. Dengan paduan rempah yang kuat dan tekstur mie yang kenyal, Mie Goreng Aceh adalah hidangan yang sangat dicari dan dihargai di seluruh Indonesia dan bahkan di luar negeri.",
                address = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345",
                addressUrl = "https://www.google.com/maps/place/The+Breeze+BSD+City,+Jl.+BSD+Green+Office+Park+Jl.+BSD+Grand+Boulevard,+Sampora,+BSD,+Kabupaten+Tangerang,+Banten+15345/data=!4m2!3m1!1s0x2e69fb03fd576c99:0xf5e7f5736ced52fa?utm_source=mstt_1&entry=gps&lucs=47068615&g_ep=CAESCTExLjk0LjMwNBgAIIgnKgg0NzA2ODYxNUICSUQ%3D"
            ),
            Menu(
                name = "Mie Ayam",
                imgUrl = "https://raw.githubusercontent.com/RaihanRafi44/foodstar-assets/main/menu_img/img_noodle_chicken.jpg",
                price = 15000.0,
                desc = "Mie Ayam adalah hidangan mi yang populer di Indonesia, terutama di warung-warung makan dan kedai mi jalanan. Hidangan ini terdiri dari mi kuning yang dimasak secara khusus dan disajikan dengan potongan daging ayam, kuah kaldu yang lezat, dan berbagai bahan pelengkap yang membuatnya menjadi sajian yang nikmat dan memuaskan. Berikut adalah deskripsi lengkapnya:\n" +
                        "\n" +
                        "Mie Ayam terdiri dari mi kuning yang digunakan sebagai basis hidangan ini. Mi tersebut biasanya merupakan mi telur, yang memberikan rasa dan warna khas yang lezat. Mi ini dimasak hingga matang, namun tetap kenyal dan tidak lembek.\n" +
                        "\n" +
                        "Daging ayam dipotong menjadi potongan kecil dan dimasak dengan berbagai bumbu rempah untuk memberikan cita rasa yang kaya dan gurih. Bumbu-bumbu seperti bawang putih, bawang merah, jahe, dan ketumbar sering digunakan dalam proses memasak daging ayam ini.\n" +
                        "\n" +
                        "Kuah kaldu yang kental dan beraroma wangi juga merupakan komponen penting dari Mie Ayam. Kuah ini biasanya dibuat dari rebusan tulang ayam, dengan tambahan bumbu-bumbu seperti bawang putih, daun bawang, dan ketumbar untuk meningkatkan cita rasanya.\n" +
                        "\n" +
                        "Selain itu, Mie Ayam juga disajikan dengan berbagai pelengkap seperti potongan daun bawang, seledri, dan bawang goreng untuk menambahkan tekstur dan rasa segar. Tambahan lainnya seperti pangsit goreng, bakso, dan sayuran seperti sawi juga sering ditemukan dalam hidangan ini, bergantung pada preferensi dan variasi regional.\n" +
                        "\n" +
                        "Untuk memberikan sentuhan rasa yang khas, beberapa versi Mie Ayam juga dilengkapi dengan sambal atau kecap manis yang dapat ditambahkan sesuai selera.\n" +
                        "\n" +
                        "Mie Ayam adalah hidangan yang menggugah selera dan seringkali dianggap sebagai hidangan sehari-hari yang nyaman dan memuaskan bagi banyak orang di Indonesia. Kombinasi mi yang kenyal, daging ayam yang gurih, dan kuah kaldu yang lezat membuat Mie Ayam menjadi pilihan favorit bagi banyak orang, baik untuk santap siang maupun malam.",
                address = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345",
                addressUrl = "https://www.google.com/maps/place/The+Breeze+BSD+City,+Jl.+BSD+Green+Office+Park+Jl.+BSD+Grand+Boulevard,+Sampora,+BSD,+Kabupaten+Tangerang,+Banten+15345/data=!4m2!3m1!1s0x2e69fb03fd576c99:0xf5e7f5736ced52fa?utm_source=mstt_1&entry=gps&lucs=47068615&g_ep=CAESCTExLjk0LjMwNBgAIIgnKgg0NzA2ODYxNUICSUQ%3D"
            ),
            Menu(
                name = "Ayam Bakar Madu",
                imgUrl = "https://raw.githubusercontent.com/RaihanRafi44/foodstar-assets/main/menu_img/img_honey_grilled_chicken.webp",
                price = 16000.0,
                desc = "Ayam Bakar Madu adalah hidangan ayam panggang yang dimasak dengan menggunakan saus madu yang kaya dan manis, memberikan cita rasa yang lezat dan menggugah selera. Berikut adalah deskripsi lengkapnya:\n" +
                        "\n" +
                        "Ayam Bakar Madu adalah hidangan ayam panggang yang terkenal akan rasa manis dan gurihnya. Potongan-potongan ayam, baik bagian dada, paha, atau sayap, direndam dalam campuran saus madu, kecap manis, bumbu-bumbu rempah, dan bahan lainnya untuk memberikan cita rasa yang kaya dan lezat.\n" +
                        "\n" +
                        "Sebelum dipanggang, potongan-potongan ayam direndam dalam campuran saus madu yang biasanya terbuat dari madu asli, kecap manis, bawang putih, jahe, dan merica. Rendaman ini memberikan rasa manis yang khas pada ayam, serta memberikan lapisan karamel yang indah saat ayam dipanggang.\n" +
                        "\n" +
                        "Setelah direndam dalam saus madu, potongan-potongan ayam dipanggang dalam oven, panggangan, atau panggangan arang, yang memberikan aroma panggangan yang khas dan memberikan tekstur renyah pada permukaan ayam.\n" +
                        "\n" +
                        "Selama proses pemanggangan, ayam sering kali diolesi dengan sisa saus madu yang tersisa untuk meningkatkan kelembaban dan rasa. Proses ini juga dapat memberikan lapisan saus yang indah pada permukaan ayam.\n" +
                        "\n" +
                        "Ayam Bakar Madu biasanya disajikan dengan pelengkap seperti nasi putih, lalapan segar seperti mentimun atau tomat, dan sambal sebagai tambahan rasa pedas. Hidangan ini sering menjadi pilihan favorit di restoran, warung makan, atau acara masakan alam terbuka, karena cita rasanya yang khas dan aroma panggangan yang menggoda.\n" +
                        "\n" +
                        "Dengan kombinasi rasa manis, gurih, dan sedikit pedas, Ayam Bakar Madu adalah hidangan yang cocok untuk dinikmati di berbagai kesempatan, mulai dari acara keluarga hingga pesta besar.",
                address = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345",
                addressUrl = "https://www.google.com/maps/place/The+Breeze+BSD+City,+Jl.+BSD+Green+Office+Park+Jl.+BSD+Grand+Boulevard,+Sampora,+BSD,+Kabupaten+Tangerang,+Banten+15345/data=!4m2!3m1!1s0x2e69fb03fd576c99:0xf5e7f5736ced52fa?utm_source=mstt_1&entry=gps&lucs=47068615&g_ep=CAESCTExLjk0LjMwNBgAIIgnKgg0NzA2ODYxNUICSUQ%3D"
            ),
            Menu(
                name = "Ayam Goreng",
                imgUrl = "https://raw.githubusercontent.com/RaihanRafi44/foodstar-assets/main/menu_img/img_fried_chicken.webp",
                price = 14000.0,
                desc = "Ayam Goreng adalah hidangan klasik yang terdiri dari potongan-potongan ayam yang digoreng hingga berwarna kecokelatan dan renyah di luar, namun tetap lembut dan juicy di dalamnya. Berikut adalah deskripsi lengkapnya:\n" +
                        "\n" +
                        "Ayam Goreng adalah hidangan yang populer di seluruh dunia, di mana potongan-potongan ayam biasanya direndam dalam campuran bumbu dan rempah, kemudian digoreng hingga matang dan berwarna kecokelatan. Ayam yang digunakan dapat berupa bagian-bagian tertentu seperti paha, dada, sayap, atau ayam utuh yang dipotong menjadi bagian-bagian lebih kecil.\n" +
                        "\n" +
                        "Sebelum digoreng, potongan-potongan ayam direndam dalam campuran bumbu yang terdiri dari bawang putih, bawang merah, jahe, ketumbar, garam, merica, dan bumbu lainnya. Rendaman ini memberikan cita rasa yang kaya dan aroma yang menggugah selera pada ayam.\n" +
                        "\n" +
                        "Setelah direndam, potongan-potongan ayam kemudian digoreng dalam minyak panas hingga berwarna kecokelatan dan renyah di luar. Proses penggorengan ini dapat dilakukan dengan menggunakan minyak goreng dalam jumlah yang cukup sehingga ayam dapat digoreng secara merata dan menghasilkan kulit yang crispy.\n" +
                        "\n" +
                        "Ayam Goreng biasanya disajikan dengan pelengkap seperti nasi putih, lalapan segar seperti mentimun atau tomat, dan sambal sebagai tambahan rasa pedas. Hidangan ini sering menjadi pilihan favorit di berbagai kesempatan, mulai dari makan malam keluarga hingga acara pesta.\n" +
                        "\n" +
                        "Dengan kombinasi rasa gurih dan renyah di luar, serta lembut dan juicy di dalamnya, Ayam Goreng adalah hidangan yang memuaskan dan cocok dinikmati oleh semua orang, dari anak-anak hingga orang dewasa.",
                address = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345",
                addressUrl = "https://www.google.com/maps/place/The+Breeze+BSD+City,+Jl.+BSD+Green+Office+Park+Jl.+BSD+Grand+Boulevard,+Sampora,+BSD,+Kabupaten+Tangerang,+Banten+15345/data=!4m2!3m1!1s0x2e69fb03fd576c99:0xf5e7f5736ced52fa?utm_source=mstt_1&entry=gps&lucs=47068615&g_ep=CAESCTExLjk0LjMwNBgAIIgnKgg0NzA2ODYxNUICSUQ%3D"
            ),
            Menu(
                name = "Sup Kepiting",
                imgUrl = "https://raw.githubusercontent.com/RaihanRafi44/foodstar-assets/main/menu_img/img_crab_asparagus_soup.jpeg",
                price = 50000.0,
                desc = "Sup kepiting adalah hidangan sup yang lezat dan mewah yang terbuat dari daging kepiting yang lembut dan beraroma, direbus dalam kaldu yang kaya rasa, dan dicampur dengan berbagai bahan tambahan untuk menciptakan rasa yang lezat dan tekstur yang menarik. Berikut adalah deskripsi lengkapnya:\n" +
                        "\n" +
                        "Sup kepiting adalah hidangan yang terbuat dari kaldu lezat yang diberi sentuhan kemewahan dengan tambahan daging kepiting segar. Daging kepiting yang telah disiapkan, baik dari kepiting sungai atau laut, dimasak dalam kaldu yang terbuat dari berbagai bumbu dan rempah, seperti bawang putih, bawang merah, jahe, daun bawang, dan kaldu ayam atau kaldu ikan.\n" +
                        "\n" +
                        "Selain daging kepiting, sup kepiting sering kali diperkaya dengan tambahan bahan-bahan lainnya seperti jagung manis, kentang, wortel, dan seledri untuk memberikan rasa dan tekstur yang beragam. Bahan-bahan ini juga menambahkan lapisan nutrisi pada hidangan ini.\n" +
                        "\n" +
                        "Sup kepiting biasanya memiliki cita rasa yang lembut dan gurih, dengan aroma yang menggugah selera dari bumbu-bumbu yang digunakan dalam proses memasak. Beberapa resep sup kepiting juga mungkin menambahkan santan atau susu untuk memberikan kekayaan dan kelembutan pada rasa sup.\n" +
                        "\n" +
                        "Hidangan ini sering disajikan sebagai hidangan pembuka dalam makan malam mewah atau acara khusus lainnya. Sup kepiting sering ditemui di restoran-restoran mewah atau di meja makan keluarga yang ingin menikmati hidangan istimewa.\n" +
                        "\n" +
                        "Dengan kombinasi daging kepiting yang lembut, kaldu yang kaya rasa, dan tambahan bahan-bahan yang beragam, sup kepiting adalah hidangan yang cocok untuk dinikmati pada berbagai kesempatan, dan sering kali dianggap sebagai sajian yang mewah dan mengesankan.",
                address = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345",
                addressUrl = "https://www.google.com/maps/place/The+Breeze+BSD+City,+Jl.+BSD+Green+Office+Park+Jl.+BSD+Grand+Boulevard,+Sampora,+BSD,+Kabupaten+Tangerang,+Banten+15345/data=!4m2!3m1!1s0x2e69fb03fd576c99:0xf5e7f5736ced52fa?utm_source=mstt_1&entry=gps&lucs=47068615&g_ep=CAESCTExLjk0LjMwNBgAIIgnKgg0NzA2ODYxNUICSUQ%3D"
            ),
            Menu(
                name = "Sayur Asem",
                imgUrl = "https://raw.githubusercontent.com/RaihanRafi44/foodstar-assets/main/menu_img/img_tamarind_vegetable_soup.jpg",
                price = 12000.0,
                desc = "Sayur Asem adalah hidangan tradisional Indonesia yang terkenal akan rasa segarnya dan citarasa yang asam. Ini adalah sup sayuran yang dimasak dengan tambahan bumbu-bumbu khas Indonesia, yang memberikan hidangan ini rasa yang kaya dan beragam. Berikut adalah deskripsi lengkapnya:\n" +
                        "\n" +
                        "Sayur Asem adalah sup sayuran yang terdiri dari berbagai macam sayuran segar seperti kacang panjang, jagung muda, labu siam, terong, tauge, dan daun melinjo. Sayuran-sayuran ini dicampur bersama dan dimasak dalam kuah yang terbuat dari air, asam Jawa, serta beberapa bumbu rempah seperti daun salam, serai, jahe, dan bawang merah.\n" +
                        "\n" +
                        "Citarasa khas dari Sayur Asem datang dari penggunaan asam Jawa yang memberikan rasa asam dan segar pada hidangan ini. Asam Jawa juga memberikan warna dan aroma yang khas pada kuah sayur asem.\n" +
                        "\n" +
                        "Selain itu, beberapa versi Sayur Asem juga dapat menambahkan bahan tambahan seperti tahu, tempe, atau daging sapi sebagai tambahan protein. Bumbu-bumbu seperti garam, gula merah, dan cabai juga ditambahkan untuk memberikan rasa yang seimbang antara asam, manis, gurih, dan pedas.\n" +
                        "\n" +
                        "Sayur Asem biasanya disajikan sebagai hidangan utama dalam makanan sehari-hari di Indonesia. Hidangan ini sering dianggap sebagai hidangan yang menyehatkan karena kandungan serat yang tinggi dari berbagai sayuran yang digunakan.\n" +
                        "\n" +
                        "Dengan kombinasi yang segar, asam, dan kaya akan nutrisi, Sayur Asem adalah hidangan yang cocok dinikmati di segala waktu, terutama saat cuaca dingin atau sebagai pelengkap dalam hidangan Indonesia lainnya.",
                address = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345",
                addressUrl = "https://www.google.com/maps/place/The+Breeze+BSD+City,+Jl.+BSD+Green+Office+Park+Jl.+BSD+Grand+Boulevard,+Sampora,+BSD,+Kabupaten+Tangerang,+Banten+15345/data=!4m2!3m1!1s0x2e69fb03fd576c99:0xf5e7f5736ced52fa?utm_source=mstt_1&entry=gps&lucs=47068615&g_ep=CAESCTExLjk0LjMwNBgAIIgnKgg0NzA2ODYxNUICSUQ%3D"
            ),
            Menu(
                name = "Tempe Mendoan",
                imgUrl = "https://raw.githubusercontent.com/RaihanRafi44/foodstar-assets/main/menu_img/img_batter_coated_fried_tempeh.webp",
                price = 8000.0,
                desc = "Tempe Mendoan adalah hidangan yang terbuat dari tempe yang dilapisi adonan berbumbu dan digoreng hingga renyah di luar dan lembut di dalamnya. Berikut adalah deskripsi lengkapnya:\n" +
                        "\n" +
                        "Tempe Mendoan adalah hidangan yang terkenal dari Indonesia, khususnya dari daerah Jawa Tengah dan Jawa Barat. Tempe, yang merupakan produk fermentasi kedelai, dipotong menjadi potongan kecil dan direndam dalam adonan berbumbu yang terbuat dari tepung terigu, bawang putih, ketumbar, garam, dan merica.\n" +
                        "\n" +
                        "Setelah direndam dalam adonan bumbu, potongan tempe kemudian digoreng dalam minyak panas hingga berwarna keemasan dan renyah di luar. Proses penggorengan ini memberikan tekstur yang crispy pada permukaan tempe, sementara bagian dalamnya tetap lembut dan penuh dengan rasa kedelai yang khas.\n" +
                        "\n" +
                        "Tempe Mendoan biasanya disajikan dengan pelengkap seperti sambal kecap, irisan tomat, mentimun, dan nasi putih. Hidangan ini sering disantap sebagai camilan atau lauk pendamping saat makan.\n" +
                        "\n" +
                        "Dengan kombinasi rasa gurih dari tempe yang telah difermentasi dan bumbu rempah yang kaya, Tempe Mendoan adalah hidangan yang menggugah selera dan sering kali menjadi favorit di antara pencinta kuliner Indonesia.",
                address = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345",
                addressUrl = "https://www.google.com/maps/place/The+Breeze+BSD+City,+Jl.+BSD+Green+Office+Park+Jl.+BSD+Grand+Boulevard,+Sampora,+BSD,+Kabupaten+Tangerang,+Banten+15345/data=!4m2!3m1!1s0x2e69fb03fd576c99:0xf5e7f5736ced52fa?utm_source=mstt_1&entry=gps&lucs=47068615&g_ep=CAESCTExLjk0LjMwNBgAIIgnKgg0NzA2ODYxNUICSUQ%3D"
            ),
            Menu(
                name = "Tahu Gejrot",
                imgUrl = "https://raw.githubusercontent.com/RaihanRafi44/foodstar-assets/main/menu_img/img_fried_tofu_in_sweet_spicy_sauce.jpg",
                price = 7000.0,
                desc = "Tahu Gejrot adalah hidangan khas dari daerah Cirebon, Jawa Barat, Indonesia. Hidangan ini terdiri dari tahu goreng yang dipotong kecil-kecil, kemudian disajikan dengan saus khas yang pedas dan manis. Berikut adalah deskripsi lengkapnya:\n" +
                        "\n" +
                        "Tahu Gejrot dimulai dengan tahu putih yang dipotong kecil-kecil dan kemudian digoreng hingga berwarna kecokelatan dan renyah di luar, namun tetap lembut di dalamnya. Tahu yang sudah digoreng kemudian diletakkan dalam mangkuk atau piring.\n" +
                        "\n" +
                        "Saus khas Tahu Gejrot terbuat dari campuran gula merah, air, cabai rawit, bawang putih, garam, dan cuka. Bahan-bahan ini kemudian dimasak hingga mendidih dan bumbu-bumbunya meresap dengan baik, menciptakan saus yang manis, pedas, dan sedikit asam.\n" +
                        "\n" +
                        "Saus tersebut kemudian dituangkan secara merata di atas potongan-potongan tahu goreng. Ketika disajikan, Tahu Gejrot biasanya ditaburi dengan bawang merah goreng atau bawang goreng sebagai tambahan rasa dan tekstur.\n" +
                        "\n" +
                        "Hidangan ini sering disajikan dengan tusukan gigi atau sumpit untuk memudahkan orang yang menyantapnya. Rasa manis, pedas, dan gurih dari sausnya bersama dengan tekstur lembut dan renyah dari tahu goreng menciptakan perpaduan rasa yang memikat.\n" +
                        "\n" +
                        "Tahu Gejrot adalah hidangan yang populer di daerah Cirebon dan sering dijadikan camilan atau jajanan khas saat bersantai. Kombinasi antara rasa tahu yang gurih dengan saus yang khas membuatnya menjadi pilihan yang lezat dan menyegarkan, terutama bagi pencinta kuliner yang menyukai cita rasa yang unik dan berani.",
                address = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345",
                addressUrl = "https://www.google.com/maps/place/The+Breeze+BSD+City,+Jl.+BSD+Green+Office+Park+Jl.+BSD+Grand+Boulevard,+Sampora,+BSD,+Kabupaten+Tangerang,+Banten+15345/data=!4m2!3m1!1s0x2e69fb03fd576c99:0xf5e7f5736ced52fa?utm_source=mstt_1&entry=gps&lucs=47068615&g_ep=CAESCTExLjk0LjMwNBgAIIgnKgg0NzA2ODYxNUICSUQ%3D"
            ),
            Menu(
                name = "Es Teh Manis",
                imgUrl = "https://raw.githubusercontent.com/RaihanRafi44/foodstar-assets/main/menu_img/img_ice_tea.jpg",
                price = 4000.0,
                desc = "Es Teh Manis adalah minuman yang menyegarkan dan populer di Indonesia, terutama saat cuaca panas. Minuman ini terdiri dari teh hitam yang diseduh kemudian disajikan dingin dengan tambahan gula cair atau gula pasir sesuai selera. Berikut adalah deskripsi lengkapnya:\n" +
                        "\n" +
                        "Es Teh Manis dimulai dengan proses penyeduhan teh hitam dalam air panas hingga rasa dan warnanya merata. Setelah diseduh, teh tersebut didinginkan dengan menggunakan es batu atau disimpan dalam lemari es hingga mencapai suhu dingin yang diinginkan.\n" +
                        "\n" +
                        "Ketika akan disajikan, teh dingin tersebut dituangkan ke dalam gelas yang telah diisi dengan es batu secukupnya. Kemudian, gula cair atau gula pasir ditambahkan sesuai selera. Beberapa orang lebih suka menambahkan perasan jeruk lemon atau jeruk nipis untuk memberikan aroma segar dan sedikit rasa asam yang menyegarkan.\n" +
                        "\n" +
                        "Es Teh Manis biasanya disajikan dalam gelas besar atau gelas kaca dengan tambahan sedotan untuk memudahkan penyantapan. Beberapa variasi juga mungkin menambahkan hiasan seperti irisan lemon, daun mint, atau buah-buahan segar sebagai garnis untuk memberikan tampilan yang lebih menarik.\n" +
                        "\n" +
                        "Minuman ini sangat populer di seluruh Indonesia, terutama di warung-warung dan kedai minuman jalanan, serta restoran dan kafe. Rasanya yang menyegarkan dan manis membuatnya menjadi minuman yang cocok untuk dinikmati di berbagai kesempatan, baik saat santai di rumah, berkumpul dengan teman, atau sebagai teman setia saat menikmati hidangan khas Indonesia.\n" +
                        "\n" +
                        "Es Teh Manis adalah pilihan yang sempurna untuk melepas dahaga dan menyegarkan tenggorokan di tengah cuaca panas. Dengan kombinasi antara rasa teh yang harum dan manisnya gula, minuman ini menjadi favorit bagi banyak orang, baik tua maupun muda.",
                address = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345",
                addressUrl = "https://www.google.com/maps/place/The+Breeze+BSD+City,+Jl.+BSD+Green+Office+Park+Jl.+BSD+Grand+Boulevard,+Sampora,+BSD,+Kabupaten+Tangerang,+Banten+15345/data=!4m2!3m1!1s0x2e69fb03fd576c99:0xf5e7f5736ced52fa?utm_source=mstt_1&entry=gps&lucs=47068615&g_ep=CAESCTExLjk0LjMwNBgAIIgnKgg0NzA2ODYxNUICSUQ%3D"
            ),
            Menu(
                name = "Es Jeruk Peras",
                imgUrl = "https://raw.githubusercontent.com/RaihanRafi44/foodstar-assets/main/menu_img/img_squeezed_orange_ice.webp",
                price = 6000.0,
                desc = "Es Jeruk Peras dimulai dengan pemilihan jeruk yang matang dan segar. Jeruk kemudian diperas dengan menggunakan alat pemeras jeruk atau manual sehingga dihasilkan jus segar yang kaya akan vitamin C dan memiliki aroma yang harum.\n" +
                        "\n" +
                        "Setelah jeruk diperas, jus jeruk tersebut kemudian disaring untuk memisahkan biji dan serat-serat kasar yang tidak diinginkan. Jus jeruk segar tersebut kemudian dituangkan ke dalam gelas yang telah diisi dengan es batu.\n" +
                        "\n" +
                        "Es Jeruk Peras biasanya tidak memerlukan tambahan gula karena rasa manis yang alami dari jeruk sudah cukup untuk memberikan kesegaran pada minuman ini. Namun, beberapa orang mungkin menambahkan sedikit gula atau pemanis lainnya sesuai dengan selera masing-masing.\n" +
                        "\n" +
                        "Minuman ini biasanya disajikan dengan sedotan untuk memudahkan penyantapan. Es Jeruk Peras sangat populer di Indonesia, terutama pada musim panas atau cuaca yang panas, karena kesegarannya yang menyegarkan dan kandungan nutrisi yang bermanfaat bagi kesehatan tubuh.\n" +
                        "\n" +
                        "Es Jeruk Peras adalah pilihan minuman yang sehat dan menyegarkan, cocok untuk dinikmati di berbagai kesempatan, baik saat santai di rumah, bersantai di pantai, atau sebagai teman setia saat bersantai di kafe atau restoran. Dengan rasa segar dan manisnya yang alami, Es Jeruk Peras menjadi favorit bagi banyak orang, baik anak-anak maupun orang dewasa.",
                address = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345",
                addressUrl = "https://www.google.com/maps/place/The+Breeze+BSD+City,+Jl.+BSD+Green+Office+Park+Jl.+BSD+Grand+Boulevard,+Sampora,+BSD,+Kabupaten+Tangerang,+Banten+15345/data=!4m2!3m1!1s0x2e69fb03fd576c99:0xf5e7f5736ced52fa?utm_source=mstt_1&entry=gps&lucs=47068615&g_ep=CAESCTExLjk0LjMwNBgAIIgnKgg0NzA2ODYxNUICSUQ%3D"
            ),

        )
    }
}