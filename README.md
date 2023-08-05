# JetBrains Academy - Recipe Project

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
  <li><a href="tasks/3-store-a-recipe/README.md">Store a Recipe</a>: Save and Delete Recipes from a database</li>
  <li><a href="tasks/4-sort-and-update/README.md">Sort & Update</a> : Filter results with queries</li>
  <li><a href="tasks/5-more-chefs-to-the-table/README.md">More Chefs to the table</a>: Learn User Authentication and authorization</li>
  </ol>
</details>
