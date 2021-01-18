## Hilt

### Sources:
	https://developer.android.com/training/dependency-injection/hilt-android#hilt-and-dagger
	https://arunkumar.dev/scabbard-dagger-hilt-integration-and-visualizing-component-hierarchies/
	https://www.youtube.com/watch?v=B56oV3IHMxg
	https://blog.mindorks.com/dagger-hilt-tutorial
	https://developer.android.com/training/dependency-injection/hilt-android

### Benifits:
	Built on dagger to make it easier and less poilerplate code
	Compile time validation same as dagger2
	Great Performance same as dagger2

### Annotations:
	@HiltAndroidApp //Annotates the application class
	@AndroidEntryPoint //Annotates the activity and fragment which use injection or contain a child that use injection
	@Inject lateinit var //To inject instances directly in classes
	@Inject constructor //To inject costructors
	@Module  @InstallIn(Component::class)  //To create a module with scoped to a component
	@Provides //To annotate functions inside module that provide dependencies
	@ApplicationContext //to bind application context
	@WithFragmentBindings //to inject instances to a custom view class using fragment bindings, the custom view class need to be annotated with this annotation
	@ActivityContext //to bind activity context but must be provided in module

### Notes

* Component is a set of factories that know how to create instances of the dependencies, 
	it's also a container that hold those instances to be able to provide them to other factories

* Base abstract classes can use @Inject annotation to be provided with dependencies without being annotated @AndroidEntryPoint

* Components:
	ApplicationComponent
	ActivityRetainedComponent      ServiceComponent
	ActivityComponent
	FragmentComponent
	ViewComponent
	ViewWithFragmentComponent

* useing jetpack view model extensions
	Note: when using viewModel extension integration cannot use FragmentComponents (Unknown)
	@ViewModelInject
	by viewModel()
    implementation 'androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha02'
    implementation "androidx.fragment:fragment-ktx:1.2.5"
    kapt 'androidx.hilt:hilt-compiler:1.0.0-alpha02'


### Scopes
	- @Singleton // must be used with @InstallIn(ApplicationComponent::class)
	- @ActivityScoped //all fragments inside activity use same instance // must be used with @InstallIn(ActivityComponent::class)
	- @FragmentScoped //all fragments and views inside fragment use same instance 
					  // must be used with @InstallIn(FragmentComponent::class)

* @EntryPoint: used for out-of-the-box injection for something like ContentProvider to be injected

* Creating custom components using @DefineComponent

* Hilt go through the class pass and create the graph of dependecies without custom components or activity builders

* @Multibinds and @IntoSet annotations to custmoize dependecies for environemnts

* Testing: 
	@HiltAndroidTest
	@UninstallModules(TestModule::class)
	class RepoTest{
		@get:Rule
		val rule = HiltAndroidRule(this)
		@Inject 
		lateinit var .......
	}

