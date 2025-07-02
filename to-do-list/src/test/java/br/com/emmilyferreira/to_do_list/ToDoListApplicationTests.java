package br.com.emmilyferreira.to_do_list;

import br.com.emmilyferreira.to_do_list.entity.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ToDoListApplicationTests {
	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testCreateTodoSuccess() {
		var todo = new Todo(1L, "todo 1", "desc todo 1", false, 1);

		webTestClient.post()
				.uri("/todos")
				.bodyValue(todo)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$.length()").isEqualTo(1)
				.jsonPath("$[0].nome").isEqualTo(todo.getNome())
				.jsonPath("$[0].descricao").isEqualTo(todo.getDescricao())
				.jsonPath("$[0].realizado").isEqualTo(todo.isRealizado())
				.jsonPath("$[0].prioridade").isEqualTo(todo.getPrioridade());
	}

	@Test
	void testCreateTodoFailure() {
		webTestClient
				.post()
				.uri("/todos")
				.bodyValue(
						new Todo(1L, "", "", false, 0)
				).exchange()
				.expectStatus().isBadRequest();
	}

	@Test
	void testUpdateTodoSuccess() {
		var todo = new Todo(1L, "todo 2", "todo desc", true, 0);

		var todoUpdate = new Todo (todo.getId(), todo.getNome(), "todo desc update", false, todo.getPrioridade() + 3);

		webTestClient.put()
				.uri("/todos")
				.bodyValue(todoUpdate)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$.length()").isEqualTo(1)
				.jsonPath("$[0].nome").isEqualTo(todo.getNome())
				.jsonPath("$[0].descricao").isEqualTo(todoUpdate.getDescricao())
				.jsonPath("$[0].realizado").isEqualTo(todoUpdate.isRealizado())
				.jsonPath("$[0].prioridade").isEqualTo(todoUpdate.getPrioridade());
	}

	@Test
	void testUpdateTodoFailure() {
		webTestClient.put()
				.uri("/todos")
				.bodyValue(new Todo(1L, "", "", false, 3))
				.exchange()
				.expectStatus().isBadRequest();
	}

	@Test
	void testDeleteTodoSuccess() {
		webTestClient.delete()
				.uri("/todos/" + 1L)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$.length()").isEqualTo(0);
	}

	@Test
	void testDeleteTodoFailure() {
		String id = "a";
		webTestClient.delete()
				.uri("/todos/" + id)
				.exchange()
				.expectStatus().isBadRequest();
	}

	@Test
	void testListTodos() {
		webTestClient.get()
				.uri("/todos")
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$.length()").isEqualTo(0);
	}



}
