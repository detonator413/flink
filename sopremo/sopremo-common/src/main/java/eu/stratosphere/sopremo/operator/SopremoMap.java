package eu.stratosphere.sopremo.operator;

import eu.stratosphere.nephele.configuration.Configuration;
import eu.stratosphere.pact.common.stub.MapStub;
import eu.stratosphere.pact.common.type.Key;
import eu.stratosphere.pact.common.type.Value;
import eu.stratosphere.pact.common.type.base.PactJsonObject;
import eu.stratosphere.sopremo.Evaluable;
import eu.stratosphere.sopremo.EvaluationContext;

public abstract class SopremoMap<IK extends Key, IV extends PactJsonObject, OK extends Key, OV extends PactJsonObject> extends
		MapStub<IK, IV, OK, OV> {
	private Evaluable transformation;

	private EvaluationContext context;

	@Override
	public void configure(Configuration parameters) {
		this.transformation = PactUtil.getObject(parameters, "transformation", Evaluable.class);
		this.context = PactUtil.getObject(parameters, "context", EvaluationContext.class);
	}

	protected EvaluationContext getContext() {
		return context;
	}

	protected Evaluable getTransformation() {
		return this.transformation;
	}
}
