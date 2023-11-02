package shamsiddin.project.navigationviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import shamsiddin.project.navigationviewexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().add(R.id.main_frame, HomeFragment()).commit()
        binding.navigationView.show(0)
        binding.navigationView.add(MeowBottomNavigation.Model(0, R.drawable.book_ic))
        binding.navigationView.add(MeowBottomNavigation.Model(1, R.drawable.search_ic))
        binding.navigationView.add(MeowBottomNavigation.Model(2, R.drawable.saved_ic))
        binding.navigationView.add(MeowBottomNavigation.Model(3, R.drawable.person_ic))

        binding.navigationView.setOnClickMenuListener {
            when(it.id){
                0 -> {
                    supportFragmentManager.beginTransaction().replace(R.id.main_frame, HomeFragment()).commit()
                }
                1 ->{
                    supportFragmentManager.beginTransaction().replace(R.id.main_frame, SavedFragment()).commit()
                }
                2 ->{
                    supportFragmentManager.beginTransaction().replace(R.id.main_frame, SearchFragment()).commit()
                }
            }
        }
    }
}