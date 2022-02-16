# kotlin-coroutines-5-mistakes
This is 5 Kotlin Coroutines mistakes that we must avoid

**Kotlin Coroutines 5 Mistakes**

<img src="https://github.com/raheemadamboev/kotlin-coroutines-5-mistakes/blob/master/banner.png" />

These are main 5 Kotlin Coroutine mistakes that we must avoid:

**1.** Getting data sequentially even though data do not depend on each other. It wastes so much time! Instead get all of them asynchronously using `async { }` block. [Link](https://github.com/raheemadamboev/kotlin-coroutines-5-mistakes/blob/master/app/src/main/java/xyz/teamgravity/kotlincoroutines5mistakes/Mistake1.kt)

**2.** Implementing your own logic of long running task in coroutine without checking coroutines activeness or lifecycle state. It may keep executing eventhough you cancel the coroutine from outside. Just checking with `isActive` or using function `ensureActive()` (throws CancelationException if coroutine is canceled) makes your coroutine safe from unintentional running. [Link](https://github.com/raheemadamboev/kotlin-coroutines-5-mistakes/blob/master/app/src/main/java/xyz/teamgravity/kotlincoroutines5mistakes/Mistake2.kt)

**3.** Not making suspend function main safe. For example, if you make network call in Main coroutine distpatcher, it may block the main thread. Always make sure to change coroutine dispatcher with function `withContext()`. [Link](https://github.com/raheemadamboev/kotlin-coroutines-5-mistakes/blob/master/app/src/main/java/xyz/teamgravity/kotlincoroutines5mistakes/Mistake3.kt)

**4.** Catching the `CancelationException` in suspend functions. Parent coroutine must know about `CancelationException`! [Link](https://github.com/raheemadamboev/kotlin-coroutines-5-mistakes/blob/master/app/src/main/java/xyz/teamgravity/kotlincoroutines5mistakes/Mistake4.kt)

**5.** Using dependent coroutine scopes for long running tasks. For instance, if you use activites lifecycle coroutine scope for long running task and activity experiences configuration change the lifecycle coroutine scope gets canceled and your task gets cancelled too. So, make sure to choose right coroutine scope for your case! [Link](https://github.com/raheemadamboev/kotlin-coroutines-5-mistakes/blob/master/app/src/main/java/xyz/teamgravity/kotlincoroutines5mistakes/Mistake5.kt)
