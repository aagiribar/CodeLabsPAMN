## Diseños realizados ##
En el fichero [MainActivity.kt](actividades/app/src/main/java/com/example/actividades/MainActivity.kt) se encuentran los tres diseños propuestos en el CodeLab ``Practice: Compose Basics``
Los diseños se encuentran en las siguientes funciones:
- Article(modifier: Modifier)

  ![Propuesta de diseño de artículo](https://developer.android.com/static/codelabs/basic-android-kotlin-compose-composables-practice-problems/img/c8c16974d0aef074_856.png)
- TaskCompleted()

  ![Propuesta de diseño de página de tareas completadas en un gestor de tareas](https://developer.android.com/static/codelabs/basic-android-kotlin-compose-composables-practice-problems/img/b5a2de2b0064e729_856.png)
- Quadrant()
  
  ![Propuesta de diseño de cuatro cuadrantes](https://developer.android.com/static/codelabs/basic-android-kotlin-compose-composables-practice-problems/img/c0c70117bbd3b5b5_856.png)

## Visualización de los diseños
Para visualizar los diferentes diseños basta con cambiar las llamadas a las diferentes funciones anteriormente descritas en la función ``onCreate()`` o en la función ``Preview()``

Por ejemplo, para visualizar el diseño del cuadrante:
```
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ActividadesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Quadrant()
                }
            }
        }
    }
}
```
```
@Preview(showBackground = true)
@Composable
fun Preview() {
    ActividadesTheme {
        Quadrant()
    }
}
```
