package dev.android.hitanshu_dhawan_mccompose.ui.menu
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.android.hitanshu_dhawan_mccompose.data.MenuRepository
import dev.android.hitanshu_dhawan_mccompose.model.Menu
import dev.android.hitanshu_dhawan_mccompose.model.MenuItem

class MenuViewModel : ViewModel() {

    private val _data = MutableLiveData(MenuRepository.getMenuData())
    val data: LiveData<Menu> = _data

    fun incrementMenuItemQuantity(menuItem: MenuItem) {
        _data.value = _data.value!!.let { menu ->
            menu.copy(
                menuItems = menu.menuItems.toMutableList().also { menuItems ->
                    menuItems[menuItems.indexOf(menuItem)] = menuItem.copy(quantity = menuItem.quantity + 1)
                }
            )
        }
    }

    fun decrementMenuItemQuantity(menuItem: MenuItem) {
        _data.value = _data.value!!.let { menu ->
            menu.copy(
                menuItems = menu.menuItems.toMutableList().also { menuItems ->
                    menuItems[menuItems.indexOf(menuItem)] = menuItem.copy(quantity = menuItem.quantity - 1)
                }
            )
        }
    }

    // TODO : Is it possible to have recomposition without copying and making a new instance of list item ?

}