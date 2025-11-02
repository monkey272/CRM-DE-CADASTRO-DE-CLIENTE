import { useForm } from "react-hook-form";
import { isEmail } from "validator";
import api from "../services/api";


//FORMULARIO DE CADASTRO
const GoodForm = () => {




  const {
    register,
    handleSubmit,
    formState: { errors },
    reset
  } = useForm();



  const onSubmit = async (data) => {
    try{
      const cliente = {
        nome: data.name,
        email: data.email,
        telefone: data.telefone,
        endereco: data.endereco,
        numero: data.numero,
        profissao: data.profession,

      };
      const response = await api.post("/cliente", cliente);
      alert("Cliente Cadastrado com sucesso !");
      console.log(" Cliente Salvo:", response.data)

      // Limpa o formulario
      reset();
    }catch(error){
      console.log("Erro ao cadastrar Cliente: ", error);
      alert("Erro ao cadastrar cliente. verifique o console: ")
    }
  };

  console.log("RENDER");

  return (
    <div className="app-container">
      <div className="form-group">
        <label>Name</label>
        <input
          className={errors?.name && "input-error"}
          type="text"
          placeholder="Your name"
          {...register("name", { required: true })}
        />
        {errors?.name?.type === "required" && (
          <p className="error-message">Nome é obrigatorio</p>
        )}
      </div>

      <div className="form-group">
        <label>E-mail</label>
        <input
          className={errors?.email && "input-error"}
          type="email"
          placeholder="Your e-mail"
          {...register("email", {
            required: true,
            validate: (value) => isEmail(value),
          })}
        />
        {errors?.email?.type === "required" && (
          <p className="error-message">Email is required.</p>
        )}

        {errors?.email?.type === "validate" && (
          <p className="error-message">Email is invalid.</p>
        )}
      </div>

      

      <div className="form-group">
        <label>Telefone</label>
        <input
          className={errors?.telefone && "input-error"}
          type="text"
          placeholder="Your Telefone"
          {...register("telefone", {
            required: true,
          })}
        />
        {errors?.telefone?.type === "required" && (
          <p className="error-message">Telefone  is required.</p>
        )}
      </div>

        <div className="form-group">
        <label>Endereço</label>
        <input
          className={errors?.endereco && "input-error"}
          type="text"
          placeholder="Rua / Avenida"
          {...register("endereco", { required: true })}
        />
        {errors?.endereco?.type === "required" && (
          <p className="error-message">Endereço is required.</p>
        )}
      </div>
      <div className="form-group">
        <label>Numero</label>
        <input
          className={errors?.numero && "input-error"}
          type="text"
          placeholder="Apto / Bloco/ ou Numero da Casa"
          {...register("numero", { required: true })}
        />
        {errors?.numero?.type === "required" && (
          <p className="error-message">Numero is required.</p>
        )}
      </div>

      <div className="form-group">
        <label>Profession</label>
        <select
          className={errors?.profession && "input-error"}
          defaultValue="0"
          {...register("profession", { validate: (value) => value !== "0" })}
        >
          <option value="0">Select your profession...</option>
          <option value="developer">Developer</option>
          <option value="other">Other</option>
        </select>

        {errors?.profession?.type === "validate" && (
          <p className="error-message">Profession is required.</p>
        )}
      </div>

      <div className="form-group">
        <div className="checkbox-group">
          <input
            type="checkbox"
            name="privacy-policy"
            {...register("privacyTerms", {
              validate: (value) => value === true,
            })}
          />
          <label>I agree with the privacy terms.</label>
        </div>

        {errors?.privacyTerms?.type === "validate" && (
          <p className="error-message">
            You must agree with the privacy terms.
          </p>
        )}
      </div>

      <div className="form-group">
        <button onClick={() => handleSubmit(onSubmit)()}>Criar conta</button>
      </div>
    </div>
  );
};

export default GoodForm;
