import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.UsuarioModel;
import com.example.demo.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
    
    AVLTree avlTree;
    HashTable hashTable;

    public UsuarioService() {
        avlTree = new AVLTree();
        hashTable = new HashTable();
    }

    public ArrayList<UsuarioModel> obtenerUsuarios() {
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public UsuarioModel guardarUsuario(UsuarioModel usuario) {
        UsuarioModel savedUsuario = usuarioRepository.save(usuario);
        avlTree.root = avlTree.insert(avlTree.root, savedUsuario.getId());
        hashTable.insert(savedUsuario.getDpi(), savedUsuario.getNombre()); // Ejemplo: usando DPI como clave
        return savedUsuario;
    }

    public Optional<UsuarioModel> obtenerPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public ArrayList<UsuarioModel> obtenerPorDpi(Integer dpi) {
        ArrayList<String> nombres = hashTable.get(dpi); // Ejemplo: obteniendo nombres de usuarios con el mismo DPI
        ArrayList<UsuarioModel> usuarios = new ArrayList<>();
        for (String nombre : nombres) {
            // Buscar usuarios por nombre
            Optional<UsuarioModel> usuario = usuarioRepository.findByNombre(nombre);
            usuario.ifPresent(usuarios::add);
        }
        return usuarios;
    }

    public boolean eliminarUsuario(Long id) {
        try {
            usuarioRepository.deleteById(id);
            // Eliminar el nodo correspondiente en el árbol AVL
            avlTree.root = avlTree.deleteNode(avlTree.root, id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
