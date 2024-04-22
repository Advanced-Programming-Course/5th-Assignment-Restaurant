در این مسئله باید قسمت‌هایی از یک اپلیکیشن مدیریت سفارشات رستوران را طبق دستور العمل داده شده پیاده‌سازی کنید.

# کلاس `Address`

این کلاس نشان دهنده‌ی یک آدرس است و دارای دو attribute طول و عرض جغرافیایی ( `latitude` و `longitude`) از نوع `double` و یک `written_address` از نوع `string` است که آدرس نوشتاری را مشخص می‌کند و . همچنین دارای متدی به اسم `distance_from` است که یک شی `Address` دیگر را به عنوان ورودی گرفته و فاصله‌ی این دو نقطه روی نقشه را با استفاده از طول و عرض جغرافیایی آنها بر حسب کیلومتر به عنوان یک متغیر `double` بازگرداند. و همه‌ی اینها باید از خارج کلاس قابل دسترسی باشند.

+ نکته: فاصله‌ی دو نقطه به کیلومتر از روی طول و عرض جغرافیایی آنها از فرمول زیر محاسبه می‌شود. lo نشان‌ دهنده‌ی طول جغرافیایی و la نشان‌دهنده‌ی عرض جغرافیایی می‌باشد.
$$distance = \sqrt{(la_2 - la_1)^{2} + (lo_2 - lo_1)^{2}}$$

# کلاس `Customer`

اشیا این کلاس نماینده‌ی مشتری‌ها در سیستم مدیریت سفارشات رستوران هستند. هر شی این کلاس یک شماره‌ی مشتری دارد که یک عدد طبیعی یونیک است و پس از ساخته‌شدن شی قابل تعویض نیست و تنها با متد `getCustomerNumber` قابل دسترسی است. همچنین این شماره باید به طور اتوماتیک موقع ساخته‌شدن شی تنظیم شود و برای هر مشتری جدید ساخته شده متفاوت باشد. همچنین برای هر مشتری یک `string` اسم باشد که با متد `getName` و `setName` قابل دسترسی است. و هر مشتری یک `Address` دارد که برای آن از کلاس آدرس تعریف شده در بالا استفاده می‌کنیم. و با `getAddress` و `setAddress` قابل دسترسی‌است.

# کلاس `Food`

هر شی از این کلاس نشان‌دهنده‌ی یک غذا در منو است. و باید یک `class variable`به نام `menu` (که یک `vector` از غذا است) برای این کلاس داشته باشیم، که هر شی‌ غذا که ساخته می‌شود به طور اتوماتیک در آن ذخیره شود. هر شی غذا دارای رشته‌ی `name` و عدد صحیح `price` است. این دو موقع ساخته‌شدن شی توسط constructor مقداردهی می‌شوند ولی بعد از آن قابل تغییر نیستند و با متد `getPrice` و `getName` صرفا قابل خواندن هستند. (به این فکر کنید که اگر یک متد setter در این سیستم برای قیمت غذا‌ها وجود داشته باشد، چه مشکلی ممکن است به وجود بیاید!)

# کلاس `Item`

هر شی این کلاس نشان دهنده‌ی یک آیتم سفارش است. هر شی `Item` دارای `food` است که از کلاس `Food` است که در بالا تعریف کردیم. و یک عدد طبیعی `count` که نشان دهنده‌ی فی است و همچنین یک `description` از نوع `string` که توضیحات اضافی در مورد این آیتم از سفارش را داراست. هر ۳ `attribute` در constructor مقداردهی می‌شوند. اما `description` می‌تواند خالی باشد. همچنین این ۳ پس از ساخته شدن شی فقط با متدهای `getFood` و `getCount` و `getDescription` قابل خوندن هستند و نباید قابل بازنویسی باشند.

# کلاس `Invoice`

این کلاس نشان‌دهنده‌ی یک فاکتور است. هر فاکتور attributeای به نام `state` دارد که اگر صفر باشد نشان‌دهنده‌ی بودن سفارش در صف آماده‌سازی، اگر ۱ باشد نشان‌دهنده‌ی بودن سفارش در صف ارسال و اگر ۲ باشد نشان‌دهنده رسیدن سفارش به دست مشتری باشد همچنین اگر -۱ باشد، نشان‌دهنده‌ی این است که سفارش در حال ثبت است. و با متد `getState` قابل خواندن است ولی خارج از کلاس تعویض نمی‌شود. یک شی Costumer برای مشتری مربوط به این سفارش (با `getCustomer()‍` صرفا دریافت می‌شود).

+ مشتری، تنها ورودی لازم برای constructor این کلاس است.

+ این کلاس باید یک متد `addItem(Item item)` داشته باشد، که یک `item` که در قسمت قبل تعریف کردیم را بگیرد و به آیتم‌های این فاکتور اضافه کند. این متد باید تنها زمانی کار کند، که در حال ثبت سفارش هستیم. در غیر این صورت باید `false` برگرداند. اگر آیتم به لیست آیتم‌های این سفارش اضافه شد، باید `true` برگرداند.

+ این کلاس باید یک متد `removeItem(Item item)` داشته باشد، که یک `item` که در قسمت قبل تعریف کردیم را بگیرد و اگر در آیتم‌های این فاکتور وجود داشت، آن را حذف کند. (منظور از وجود داشتن این است که itemای با غذای مشابه در itemهای این سفارش وجود داشته باشد). این متد باید تنها زمانی کار کند، که در حال ثبت سفارش هستیم. در صورت نبودن در وضعیت ثبت سفارش یا وجود نداشتن این `item` در آیتم‌های این سفارش باید به نشانه‌ی انجام نشدن عملیات، `false` برگرداند. در صورت انجام شدن عملیات باید `true` برگرداند.

+ متد `nextStage()` وضعیت سفارش را یک مرحله به جلو می‌برد.

+ متد `getTotalPrice` قیمت کل سفارش را به صورت یک ‍`integer` برمی‌گرداند. دقت کنید که قیمت کل سفارش برابر قیمت کل item‌ها به علاوه‌ی مالیات است و رو به بالا گرد می‌شود . نرخ مالیات باید به صورت یک `class variable` در این کلاس به صورت یک متغیر `float` به نام `tax_rate` ذخیره شود و مقدار آن همیشه برابر با 9.4 درصد و غیرقابل تغییر است.

کلاس حداقل باید یک constructor داشته باشد، که با استفاده از اسم و آدرس یک شی مشتری بسازد.

جواب را به صورت یک فایل zip ارسال کنید که در آن یک پوشه `restaurant` وجود دارد و در داخل آن فایل‌های `Address.java` , `Customer.java` , `Food.java` , `Item.java` , `Invoice.java` , `Restaurant.java` موجود باشد.

## نمونه استفاده از برنامه (تابع main)
```
public static void main(String[] args) {
    Address a1 = new Address(2, 3, "Lahijan");
    Address a2 = new Address(5, 6, "Tehran");

    System.out.println("\n--------------------------------------\n");
    System.out.println("Distance From Address a1 to a2 is: " + a1.distanceFrom(a2));
    System.out.println("\n--------------------------------------\n");

    Customer c1 = new Customer("MAMAD", a1);
    Customer c2 = new Customer("ALI", a2);

    System.out.println("First Customer's ID: " + c1.getCustomerNumber());
    System.out.println("Second Customer's ID: " + c2.getCustomerNumber());

    Food f1 = new Food("BURGER", 130);
    Food f2 = new Food("PIZZA", 200);
    Food f3 = new Food("PASTA", 110);

    System.out.println("\n--------------------------------------\n");

    for (int i = 0; i < Food.getMenu().size(); i++) {
        System.out.println("Food Name: " + Food.getMenu().get(i).getName());
    }

    System.out.println("\n--------------------------------------\n");

    Item it1 = new Item(f1, 2);
    Item it2 = new Item(f2, 3, "MORE SAUCE");
    Item it3 = new Item(f3, 1);

    Invoice inv = new Invoice(c1);

    if (inv.addItem(it1) && inv.addItem(it2)) System.out.println("Items added successfully");
    else System.out.println("Items could not be added");

    if (inv.removeItem(it3)) System.out.println("Item removed successfully");
    else System.out.println("Failed to remove item (item doesn't exist in invoice)");

    inv.nextStage();

    System.out.println("Current state: " + inv.getState());

    System.out.println("\n--------------------------------------\n");

    for (int i = 0; i < inv.getItems().size(); i++) {
        Item it = inv.getItems().get(i);
        System.out.println("Food Name: " + it.getFood().getName() + " | Food Description: " + it.getDescription());
    }

    System.out.println("Total price: " + inv.getTotalPrice());
}
```
## خروجی نمونه
```
--------------------------------------

Distance From Address a1 to a2 is:4.24264

--------------------------------------

First Customer's ID: 1
Second Customer's ID: 2

--------------------------------------

Food Name: BURGER
Food Name: PIZZA
Food Name: PASTA

--------------------------------------

Items added successfully
Failed to remove item (item doesn't exist in invoice)
Current state: 0

--------------------------------------

Food Name: BURGER | Food Description: -
Food Name: PIZZA | Food Description: MORE SAUCE
Total price: 941
```
