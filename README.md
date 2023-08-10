# JetBrains Academy - Recipe Project
We all were in a situation when we wanted to cook something special but couldn't remember a recipe. Let's create a program that can store all recipes in one place. The program is a multi-user web service based on Spring Boot that allows storing, retrieving, updating, and deleting recipes.

<br />
<p align="center">
  <a href="https://hyperskill.org/projects/130">
    <img src="https://ictacademy.com.ng/wp-content/uploads/2020/02/1200px-JetBrains_Logo_2016.svg_.png" alt="Logo" height="80">
  </a>

<p align="center">Recipe Project, is a graduate project for the Java Backend Developer track.
<p align="center"><img src="https://img.icons8.com/color/30/000000/java-coffee-cup-logo--v1.png" alt="Java"><img src="https://img.icons8.com/color/30/000000/spring-logo.png" alt="Spring Framework"><img src="https://img.icons8.com/color/30/000000/postgreesql.png"/>
</p>

## About

An urge to cook something special is too hard to resist sometimes. But what if you lost the recipe? Or your beloved grandma is too busy to answer a call and remind you of your favorite cake recipe? Let's make a program that stores all recipes in one place. Create a multi-user web service with Spring Boot that allows storing, retrieving, updating, and deleting recipes.
## Learning Outcomes

Get to know the backend development. Use Spring Boot to complete this project. Learn about JSON, REST API, Spring Boot Security, H2 database, LocalDateTime, Project Lombok, and other concepts useful for the backend.
This project is a part of the following track
Java Backend Developer.

What you’ll do and what you’ll learn

<details open="open">
  <summary>Task Details</summary>
  <ol>
  <li><a href="tasks/1-first-recipe/README.md">First Recipe</a>: Create a Spring Boot Project with Endpoints</li>
    <h5 id="description">Description</h5>

<p>We all were in a situation when we wanted to cook something special but couldn't remember a recipe. Let's create a program that can store all recipes in one place. The program is a multi-user web service based on Spring Boot that allows storing, retrieving, updating, and deleting recipes.</p>

<p>In the first stage, you'll implement a simple service that supports two operations: adding (<code class="language-json">POST /api/recipe</code>), and retrieving (<code class="language-json">GET /api/recipe</code>) a recipe. The service will be able to store only one recipe at a time. Every new recipe added via <code class="language-json">POST</code> request will override the previous one. We will improve the service to support multiple recipes in the stages to come.</p>

<p>A recipe includes 4 fields: <code class="language-json">name</code> , <code class="language-json">description</code>, <code class="language-json">ingredients</code>, <code class="language-json">directions</code>. Here's an example of the <code class="language-json">Fresh Mint Tea</code> recipe:</p>

<pre><code class="language-json">{
   "name": "Fresh Mint Tea",
   "description": "Light, aromatic and refreshing beverage, ...",
   "ingredients": "boiled water, honey, fresh mint leaves",
   "directions": "1) Boil water. 2) Pour boiling hot water into a mug. 3) Add fresh mint leaves. 4) Mix and let the mint leaves seep for 3-5 minutes. 5) Add honey and mix again."
}</code></pre>

<h5 id="theory">Theory</h5>

<p>With Spring Boot, we need to write data classes with a lot of getters, setters, and constructors; having a readable <code class="language-json">toString</code> is also a good idea. Getters and setters are often simple, they return or store a value. Manually writing these methods may be tedious and lead to errors. To simplify this process, we can use a very simple but powerful <a target="_blank" target="_blank" target="_blank" target="_blank" target="_blank" href="https://projectlombok.org/features/all" rel="noopener noreferrer nofollow">Project Lombok</a> library. It can generate all these methods during compilation and reduces the number of lines and bugs. It also improves code readability and maintainability. Take a look at the example below:</p>

<pre><code class="language-java">@Data
@AllArgsConstructor
@NoArgsConstructor
class Animal {
   String name;
   int age;
   int weight;
}</code></pre>

<p><code class="language-json">@Data</code> annotation automatically generates getters (for all fields), setters (for all non-final fields), <code class="language-json">hashCode</code>, <code class="language-json">equals</code>, and a readable <code class="language-json">toString</code> method. Second and third annotation generates constructors. The annotations can be different — if you want to know more about this library, take a look at the link above. The library is already imported; feel free to use this library not only with Spring Boot but also with any other Java program.</p>

<p>The tests won't check whether you use Project Lombok or not.</p>

<h5 id="objectives">Objectives</h5>

<p>Implement two endpoints:</p>

<ul>
	<li><code class="language-json">POST /api/recipe</code> receives a recipe as a JSON object and overrides the current recipe.</li>
	<li><code class="language-json">GET /api/recipe</code> returns the current recipe as a JSON object.</li>
</ul>

<p>The initial recipe can have any form.</p>

<h5 id="examples">Examples</h5>

<p><strong>Example 1: </strong><code class="language-json">POST /api/recipe</code> request with the following body:</p>

<pre><code class="language-json">{
   "name": "Fresh Mint Tea",
   "description": "Light, aromatic and refreshing beverage, ...",
   "ingredients": "boiled water, honey, fresh mint leaves",
   "directions": "1) Boil water. 2) Pour boiling hot water into a mug. 3) Add fresh mint leaves. 4) Mix and let the mint leaves seep for 3-5 minutes. 5) Add honey and mix again."
}</code></pre>

<p><strong>Example 2: </strong>Response for a <code class="language-json">GET /api/recipe</code> request:</p>

<pre><code class="language-json">{
   "name": "Fresh Mint Tea",
   "description": "Light, aromatic and refreshing beverage, ...",
   "ingredients": "boiled water, honey, fresh mint leaves",
   "directions": "1) Boil water. 2) Pour boiling hot water into a mug. 3) Add fresh mint leaves. 4) Mix and let the mint leaves seep for 3-5 minutes. 5) Add honey and mix again."
}</code></pre>
  <li><a href="tasks/2-multiple-recipes/README.md">Multiple Recipes</a>: Save and Delete recipes in memory</li>
  <h5 id="description">Description</h5>

<p>Our service can store only one recipe at a time which is not very convenient. In this stage, improve the service to store a lot of recipes and access recipes by a unique <code class="language-json">id</code>. Some changes in the recipe structure are also required.</p>

<p>The new structure of a recipe includes the same 4 fields, but the type of two of them is different. <code class="language-json">ingredients</code> and <code class="language-json">directions</code> should now be arrays. Here's an example of the new structure:</p>

<pre><code class="language-json">{
   "name": "Warming Ginger Tea",
   "description": "Ginger tea is a warming drink for cool weather, ...",
   "ingredients": ["1 inch ginger root, minced", "1/2 lemon, juiced", "1/2 teaspoon manuka honey"],
   "directions": ["Place all ingredients in a mug and fill with warm water (not too hot so you keep the beneficial honey compounds in tact)", "Steep for 5-10 minutes", "Drink and enjoy"]
}</code></pre>

<h5 id="objectives">Objectives</h5>

<p>Rearrange the existing endpoints; the service should support the following:</p>

<ul>
	<li><code class="language-json">POST /api/recipe/new</code> receives a recipe as a JSON object and returns a JSON object with one <code class="language-json">id</code> field. This is a uniquely generated number by which we can identify and retrieve a recipe later. The status code should be <code class="language-json">200 (Ok)</code>.</li>
	<li><code class="language-json">GET /api/recipe/{id}</code> returns a recipe with a specified <code class="language-json">id</code> as a JSON object (where <code class="language-json">{id}</code> is the <code class="language-json">id</code> of a recipe). The server should respond with the <code class="language-json">200 (Ok)</code> status code. If a recipe with a specified <code class="language-json">id</code> does not exist, the server should respond with <code class="language-json">404 (Not found)</code>.</li>
</ul>

<h5 id="examples">Examples</h5>

<p><strong>Example 1</strong>: <code class="language-json">POST /api/recipe/new</code> request with the following body:</p>

<pre><code class="language-json">{
   "name": "Fresh Mint Tea",
   "description": "Light, aromatic and refreshing beverage, ...",
   "ingredients": ["boiled water", "honey", "fresh mint leaves"],
   "directions": ["Boil water", "Pour boiling hot water into a mug", "Add fresh mint leaves", "Mix and let the mint leaves seep for 3-5 minutes", "Add honey and mix again"]
}</code></pre>

<p>Response:</p>

<pre><code class="language-json">{
   "id": 1
}</code></pre>

<p><strong>Example 2</strong>: <code class="language-json">GET /api/recipe/1</code> request</p>

<p>Response:</p>

<pre><code class="language-json">{
   "name": "Fresh Mint Tea",
   "description": "Light, aromatic and refreshing beverage, ...",
   "ingredients": ["boiled water", "honey", "fresh mint leaves"],
   "directions": ["Boil water", "Pour boiling hot water into a mug", "Add fresh mint leaves", "Mix and let the mint leaves seep for 3-5 minutes", "Add honey and mix again"]
}</code></pre>

<p><strong>Example 3</strong>: <code class="language-json">GET /api/recipe/999</code> request</p>

<p>Status code: <code class="language-json">404 (Not found)</code></p>
  <li><a href="tasks/3-store-a-recipe/README.md">Store a Recipe</a>: Save and Delete Recipes from a database</li>
  <h5 id="description">Description</h5>

<p>In the previous stage, we have improved our service, so it can handle a lot of recipes. But when we close our program, it deletes all recipes. In this stage, you'll implement one of the main features of the service – connect the service to a database and store the recipes there. No more lost recipes!</p>

<p>You will also need a new endpoint that will allow deleting a recipe by the recipe <code class="language-java">id</code>. Make sure that the service accepts only valid recipes – recipes without directions or ingredients are frustrating. We won't change the recipe structure in this stage.</p>

<h5 id="objectives">Objectives</h5>

<p>First of all, include all necessary dependencies and configurations in the <code class="language-java">build.gradle</code> and <code class="language-java">application.properties</code> files.</p>

<p>For testing reasons, the <code class="language-java">application.properties</code> file should contain the following line with the database name:</p>

<pre><code class="language-java">spring.datasource.url=jdbc:h2:file:../recipes_db</code></pre>

<p>The service should support the same endpoints as in the previous stage:</p>

<ul>
	<li><code class="language-java">POST /api/recipe/new</code> receives a recipe as a JSON object and returns a JSON object with one <code class="language-java">id</code> field;</li>
	<li><code class="language-java">GET /api/recipe/{id}</code> returns a recipe with a specified <code class="language-java">id</code> as a JSON object.</li>
</ul>

<p>To complete the stage you need to add the following functionality:</p>

<ul>
	<li>Store all recipes permanently in a database: after a server restart, all added recipes should be available to a user;</li>
	<li>Implement a new <code class="language-java">DELETE /api/recipe/{id}</code> endpoint. It deletes a recipe with a specified <code class="language-java">{id}</code>. The server should respond with the <code class="language-json">204 (No Content)</code> status code. If a recipe with a specified id does not exist, the server should return <code class="language-json">404 (Not found)</code>;</li>
	<li>The service should accept only valid recipes – all fields are obligatory, <code class="language-java">name</code> and <code class="language-java">description</code> shouldn't be blank, and JSON arrays should contain at least one item. If a recipe doesn't meet these requirements, the service should respond with the <code class="language-json">400 (Bad Request)</code> status code.</li>
</ul>

<h5 id="examples">Examples</h5>

<p><strong>Example 1: </strong><code class="language-java">POST /api/recipe/new</code> request</p>

<pre><code class="language-json">{
   "name": "Warming Ginger Tea",
   "description": "Ginger tea is a warming drink for cool weather, ...",
   "ingredients": ["1 inch ginger root, minced", "1/2 lemon, juiced", "1/2 teaspoon manuka honey"],
   "directions": ["Place all ingredients in a mug and fill with warm water (not too hot so you keep the beneficial honey compounds in tact)", "Steep for 5-10 minutes", "Drink and enjoy"]
}</code></pre>

<p>Response:</p>

<pre><code class="language-json">{
   "id": 1
}</code></pre>

<p><strong>Example 2: </strong>Response for the<strong> </strong><code class="language-java">GET /api/recipe/1</code> request</p>

<pre><code class="language-json">{
   "name": "Warming Ginger Tea",
   "description": "Ginger tea is a warming drink for cool weather, ...",
   "ingredients": ["1 inch ginger root, minced", "1/2 lemon, juiced", "1/2 teaspoon manuka honey"],
   "directions": ["Place all ingredients in a mug and fill with warm water (not too hot so you keep the beneficial honey compounds in tact)", "Steep for 5-10 minutes", "Drink and enjoy"]
}</code></pre>

<p><strong>Example 3: </strong></p>

<p><code class="language-java">DELETE /api/recipe/1</code> request</p>

<p>Status code: <code class="language-json">204 (No Content)</code></p>

<p><code class="language-java">DELETE /api/recipe/1</code> request</p>

<p>Status code: <code class="language-json">404 (Not found)</code></p>

<p><strong>Example 4:</strong></p>

<p><code class="language-java">GET /api/recipe/1</code> request</p>

<p>Status code: <code class="language-json">404 (Not found)</code></p>
  <li><a href="tasks/4-sort-and-update/README.md">Sort & Update</a> : Filter results with queries</li>
  <h5 id="description">Description</h5>

<p>In this stage, we continue with improving our application. It would be good to retrieve all recipes related to a category (beverages, salads, desserts, and so on), to search for a recipe by name, to update a recipe, or to find out when a recipe was uploaded or updated. To do that, you need two additional fields: <code class="language-json">category</code> and <code class="language-json">date</code>. One field is a recipe category, the other field stores the date. You also need to add two new endpoints. One endpoint will update recipes, the other receives the query parameters that will allow searching for recipes by a category or name.</p>

<h5 id="objectives">Objectives</h5>

<p>Don't forget to keep the functionality from the previous stages. This is what your program can do:</p>

<ul>
	<li><code class="language-json">POST /api/recipe/new</code> receives a recipe as a JSON object and returns a JSON object with one <code class="language-json">id</code> field;</li>
	<li><code class="language-json">GET /api/recipe/{id}</code> returns a recipe with a specified <code class="language-json">id</code> as a JSON object;</li>
	<li><code class="language-json">DELETE /api/recipe/{id}</code> deletes a recipe with a specified <code class="language-json">id</code>.</li>
</ul>

<p>In this stage, the recipe structure should contain two new fields:</p>

<ul>
	<li><code class="language-json">category</code> represents a category of a recipe. The field has the same restrictions as <code class="language-json">name</code> and <code class="language-json">description</code>. It shouldn't be blank;</li>
	<li><code class="language-json">date</code> stores the date when the recipe has been added (or the last update). You can use any date/time format, for example <code class="language-json">2021-09-05T18:34:48.227624</code> (the default <code class="language-json">LocalDateTime</code> format), but the field should have at least 8 characters.</li>
</ul>

<p>Also, the service should support the following endpoints:</p>

<ul>
	<li><code class="language-json">PUT /api/recipe/{id}</code> receives a recipe as a JSON object and updates a recipe with a specified <code class="language-json">id</code>. Also, update the <code class="language-json">date</code> field too. The server should return the <code class="language-json">204 (No Content)</code> status code. If a recipe with a specified <code class="language-json">id</code> does not exist, the server should return <code class="language-json">404 (Not found)</code>. The server should respond with <code class="language-json">400 (Bad Request)</code> if a recipe doesn't follow the restrictions indicated above (all fields are required, string fields can't be blank, arrays should have at least one item);</li>
	<li><code class="language-json">GET /api/recipe/search</code> takes one of the two mutually exclusive query parameters:
	<ol>
		<li><code class="language-json">category</code> – if this parameter is specified, it returns a JSON array of all recipes of the specified category. Search is case-insensitive, sort the recipes by date (newer first);</li>
		<li><code class="language-json">name</code> – if this parameter is specified, it returns a JSON array of all recipes with the names that <strong>contain</strong> the specified parameter. Search is case-insensitive, sort the recipes by date (newer first). </li>
	</ol>

	<p>If no recipes are found, the program should return an empty JSON array. If 0 parameters were passed, or more than 1, the server should return <code class="language-json">400 (Bad Request)</code>. The same response should follow if the specified parameters are not valid. If everything is correct, it should return <code class="language-json">200 (Ok)</code>.</p>
	</li>
</ul>

<p>There is a couple of ways to do that. Check the examples below for details. If you need more theory on how to get data from a database or how to process query parameters, take a look at <a target="_blank" target="_blank" target="_blank" target="_blank" target="_blank" href="https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods" rel="noopener noreferrer nofollow">Query Methods</a> paragraph in the Official Documentation (check the table), or the <code class="language-json">@RequestParam</code> <a target="_blank" target="_blank" target="_blank" target="_blank" target="_blank" href="https://www.baeldung.com/spring-request-param" rel="noopener noreferrer nofollow">annotation</a>.</p>

<h5 id="examples">Examples</h5>

<p><strong>Example 1: </strong><code class="language-json">POST /api/recipe/new</code> request</p>

<pre><code class="language-json">{
   "name": "Fresh Mint Tea",
   "category": "beverage",
   "description": "Light, aromatic and refreshing beverage, ...",
   "ingredients": ["boiled water", "honey", "fresh mint leaves"],
   "directions": ["Boil water", "Pour boiling hot water into a mug", "Add fresh mint leaves", "Mix and let the mint leaves seep for 3-5 minutes", "Add honey and mix again"]
}</code></pre>

<p>Response:</p>

<pre><code class="language-json">{
   "id": 1
}</code></pre>

<p>Further <code class="language-json">GET /api/recipe/1</code> response:</p>

<pre><code class="language-json">{
   "name": "Fresh Mint Tea",
   "category": "beverage",
   "date": "2020-01-02T12:11:25.034734",
   "description": "Light, aromatic and refreshing beverage, ...",
   "ingredients": ["boiled water", "honey", "fresh mint leaves"],
   "directions": ["Boil water", "Pour boiling hot water into a mug", "Add fresh mint leaves", "Mix and let the mint leaves seep for 3-5 minutes", "Add honey and mix again"]
}</code></pre>

<p><button
        class="btn-sm btn-outline-secondary"
        onclick="getElementById('hint-4964').style.display='inline'">
        Hint
      </button>
      <div id="hint-4964" style="display:none;">The <code class="language-json">date</code> field is present in the response only.</div></p>

<p><strong>Example 2</strong>: <code class="language-json">PUT /api/recipe/1</code> request</p>

<pre><code class="language-json">{
   "name": "Warming Ginger Tea",
   "category": "beverage",
   "description": "Ginger tea is a warming drink for cool weather, ...",
   "ingredients": ["1 inch ginger root, minced", "1/2 lemon, juiced", "1/2 teaspoon manuka honey"],
   "directions": ["Place all ingredients in a mug and fill with warm water (not too hot so you keep the beneficial honey compounds in tact)", "Steep for 5-10 minutes", "Drink and enjoy"]
}</code></pre>

<p>Further response for the <code class="language-json">GET /api/recipe/1</code> request:</p>

<pre><code class="language-json">{
   "name": "Warming Ginger Tea",
   "category": "beverage",
   "date": "2021-04-06T14:10:54.009725",
   "description": "Ginger tea is a warming drink for cool weather, ...",
   "ingredients": ["1 inch ginger root, minced", "1/2 lemon, juiced", "1/2 teaspoon manuka honey"],
   "directions": ["Place all ingredients in a mug and fill with warm water (not too hot so you keep the beneficial honey compounds in tact)", "Steep for 5-10 minutes", "Drink and enjoy"]
}</code></pre>

<p><strong>Example 3</strong>: A database with several recipes</p>

<pre><code class="language-json">{
   "name": "Iced Tea Without Sugar",
   "category": "beverage",
   "date": "2019-07-06T17:12:32.546987",
   ....
},
{
   "name": "vegan avocado ice cream",
   "category": "DESSERT",
   "date": "2020-01-06T13:10:53.011342",
   ....
},
{
   "name": "Fresh Mint Tea",
   "category": "beverage",
   "date": "2021-09-06T14:11:51.006787",
   ....
},
{
   "name": "Vegan Chocolate Ice Cream",
   "category": "dessert",
   "date": "2021-04-06T14:10:54.009345",
   ....
},
{
   "name": "warming ginger tea",
   "category": "beverage",
   "date": "2020-08-06T14:11:42.456321",
   ....
}</code></pre>

<p>Response for the <code class="language-json">GET /api/recipe/search/?category=dessert</code> request:</p>

<pre><code class="language-json">[
   {
      "name": "Vegan Chocolate Ice Cream",
      "category": "dessert",
      "date": "2021-04-06T14:10:54.009345",
      ....
   },
   {
      "name": "vegan avocado ice cream",
      "category": "DESSERT",
      "date": "2020-01-06T13:10:53.011342",
      ....
   },
]</code></pre>

<p>Response for the <code class="language-json">GET /api/recipe/search/?name=tea</code> request:</p>

<pre><code class="language-json">[
   {
      "name": "Fresh Mint Tea",
      "category": "beverage",
      "date": "2021-09-06T14:11:51.006787",
      ....
   },
   {
      "name": "warming ginger tea",
      "category": "beverage",
      "date": "2020-08-06T14:11:42.456321",
      ....
   },
   {
      "name": "Iced Tea Without Sugar",
      "category": "beverage",
      "date": "2019-07-06T17:12:32.546987",
      ....
   },
]</code></pre>

<p>Search is case-insensitive, the recipes are sorted by date.</p>
  <li><a href="tasks/5-more-chefs-to-the-table/README.md">More Chefs to the table</a>: Learn User Authentication and authorization</li>
  <h5 id="description">Description</h5>

<p>Imagine a service that supports the registration process, can handle a lot of users, and each of them can add their own recipes. Also, a user can update or delete only their recipes but can view recipes added by other users. In this stage, you will implement all this functionality with Spring Boot Security.</p>

<p>The stage is divided into 3 steps. In the first step, you need to add an endpoint responsible for the user registration. The endpoint receives 2 fields: <code class="language-json">email</code> and <code class="language-json">password</code>. The second step is to enable Spring Security and configure the access restrictions – only the registered users with the correct login and password should have the rights to use the service. After that, restrict the deletion and updating to the recipe author only.</p>

<h5 id="objectives">Objectives</h5>

<p>The service should contain all features from the previous stages. To complete the project, you need to add the following functionality:</p>

<ul>
	<li>New endpoint <code class="language-json">POST /api/register</code> receives a JSON object with two fields: <code class="language-json">email</code> (string), and <code class="language-json">password</code> (string). If a user with a specified email does not exist, the program saves (registers) the user in a database and responds with <code class="language-json">200 (Ok)</code>. If a user is already in the database, respond with the <code class="language-json">400 (Bad Request)</code> status code. Both fields are <strong>required</strong> and must be <strong>valid</strong>: <code class="language-json">email</code> should contain <code class="language-json">@</code> and <code class="language-json">.</code> symbols, <code class="language-json">password</code> should contain at least 8 characters and shouldn't be blank. If the fields do not meet these restrictions, the service should respond with <code class="language-json">400 (Bad Request)</code>. Also, do not forget to use an encoder before storing a password in a database. <code class="language-json">BCryptPasswordEncoder</code> is a good choice.</li>
	<li>Include the Spring Boot Security dependency and configure access to the endpoints – all implemented endpoints (except <code class="language-json">/api/register</code>) should be available only to the registered and then authenticated and authorized via HTTP Basic auth users. Otherwise, the server should respond with the <code class="language-json">401 (Unauthorized)</code> status code.</li>
	<li>Add additional restrictions – only an author of a recipe can delete or update a recipe. If a user is not the author of a recipe, but they try to carry out the actions mentioned above, the service should respond with the <code class="language-json">403 (Forbidden)</code> status code.</li>
</ul>

<p><div class="alert alert-warning">For testing purposes, <code class="language-json">POST</code><code class="language-json">/actuator/shutdown</code> should be available without authentication.</div></p>

<p><button
        class="btn-sm btn-outline-secondary"
        onclick="getElementById('hint-2793').style.display='inline'">
        Hint
      </button>
      <div id="hint-2793" style="display:none;">If you use Postman or any similar program for testing and receive <code class="language-json">403 (Forbidden)</code>, try to disable <strong>CSRF </strong>(Cross-Site Request Forgery) protection. You can disable this type of protection by calling the following methods – <code class="language-json">.csrf().disable()</code> on the <code class="language-json">HttpSecurity</code> instance that was obtained after overriding the <code class="language-json">configure</code> method.</p>

<p>If you use the H2 console, you need to unblock it by disabling <strong>CSRF</strong> and <strong>X-Frame-Options </strong>that prevents clickjacking attacks, by calling the following methods: <code class="language-json">.csrf().disable().headers().frameOptions().disable()</code> on the <code class="language-json">HttpSecurity</code> instance. Also, make sure that Spring Security does not block the H2 console URLs.</div></p>

<h5 id="examples">Examples</h5>

<p><strong>Example 1: </strong><code class="language-json">POST /api/recipe/new</code> request without authentication</p>

<pre><code class="language-json">{
   "name": "Fresh Mint Tea",
   "category": "beverage",
   "description": "Light, aromatic and refreshing beverage, ...",
   "ingredients": ["boiled water", "honey", "fresh mint leaves"],
   "directions": ["Boil water", "Pour boiling hot water into a mug", "Add fresh mint leaves", "Mix and let the mint leaves seep for 3-5 minutes", "Add honey and mix again"]
}</code></pre>

<p>Status code: <code class="language-json">401 (Unauthorized)</code></p>

<p><strong>Example 2: </strong><code class="language-json">POST /api/register</code> request without authentication</p>

<pre><code class="language-json">{
   "email": "Cook_Programmer@somewhere.com",
   "password": "RecipeInBinary"
}</code></pre>

<p>Status code: <code class="language-json">200 (Ok)</code></p>

<p>Further <code class="language-json">POST /api/recipe/new</code> request with basic authentication; email (login): Cook_Programmer@somewhere.com, and password: RecipeInBinary</p>

<pre><code class="language-json">{
   "name": "Mint Tea",
   "category": "beverage",
   "description": "Light, aromatic and refreshing beverage, ...",
   "ingredients": ["boiled water", "honey", "fresh mint leaves"],
   "directions": ["Boil water", "Pour boiling hot water into a mug", "Add fresh mint leaves", "Mix and let the mint leaves seep for 3-5 minutes", "Add honey and mix again"]
}</code></pre>

<p>Response:</p>

<pre><code class="language-json">{
   "id": 1
}</code></pre>

<p>Further <code class="language-json">PUT /api/recipe/1</code> request with basic authentication; email (login): Cook_Programmer@somewhere.com, password: RecipeInBinary</p>

<pre><code class="language-json">{
   "name": "Fresh Mint Tea",
   "category": "beverage",
   "description": "Light, aromatic and refreshing beverage, ...",
   "ingredients": ["boiled water", "honey", "fresh mint leaves"],
   "directions": ["Boil water", "Pour boiling hot water into a mug", "Add fresh mint leaves", "Mix and let the mint leaves seep for 3-5 minutes", "Add honey and mix again"]
}</code></pre>

<p>Status code: <code class="language-json">204 (No Content)</code></p>

<p>Further <code class="language-json">GET /api/recipe/1</code> request with basic authentication; email (login): Cook_Programmer@somewhere.com, password: RecipeInBinary</p>

<p>Response:</p>

<pre><code class="language-json">{
   "name": "Fresh Mint Tea",
   "category": "beverage",
   "date": "2020-01-02T12:11:25.034734",
   "description": "Light, aromatic and refreshing beverage, ...",
   "ingredients": ["boiled water", "honey", "fresh mint leaves"],
   "directions": ["Boil water", "Pour boiling hot water into a mug", "Add fresh mint leaves", "Mix and let the mint leaves seep for 3-5 minutes", "Add honey and mix again"]
}</code></pre>

<p><strong>Example 3: </strong><code class="language-json">POST /api/register</code> request without authentication</p>

<pre><code class="language-json">{
   "email": "CamelCaseRecipe@somewhere.com",
   "password": "C00k1es."
}</code></pre>

<p>Status code: <code class="language-json">200 (Ok)</code></p>

<p>Further response for the <code class="language-json">GET /api/recipe/1</code> request with basic authentication; email (login): CamelCaseRecipe@somewhere.com, password: C00k1es.</p>

<pre><code class="language-json">{
   "name": "Fresh Mint Tea",
   "category": "beverage",
   "date": "2020-01-02T12:11:25.034734",
   "description": "Light, aromatic and refreshing beverage, ...",
   "ingredients": ["boiled water", "honey", "fresh mint leaves"],
   "directions": ["Boil water", "Pour boiling hot water into a mug", "Add fresh mint leaves", "Mix and let the mint leaves seep for 3-5 minutes", "Add honey and mix again"]
}</code></pre>

<p>Further <code class="language-json">PUT /api/recipe/1</code> request with basic authentication; email (login): CamelCaseRecipe@somewhere.com, password: C00k1es.</p>

<pre><code class="language-json">{
   "name": "Warming Ginger Tea",
   "category": "beverage",
   "description": "Ginger tea is a warming drink for cool weather, ...",
   "ingredients": ["1 inch ginger root, minced", "1/2 lemon, juiced", "1/2 teaspoon manuka honey"],
   "directions": ["Place all ingredients in a mug and fill with warm water (not too hot so you keep the beneficial honey compounds in tact)", "Steep for 5-10 minutes", "Drink and enjoy"]
}</code></pre>

<p>Status code: <code class="language-json">403 (Forbidden)</code></p>

<p>Further <code class="language-json">DELETE /api/recipe/1</code> request with basic authentication; email (login): CamelCaseRecipe@somewhere.com, password: C00k1es.</p>

<p>Status code: <code class="language-json">403 (Forbidden)</code></p>
  </ol>
</details>
